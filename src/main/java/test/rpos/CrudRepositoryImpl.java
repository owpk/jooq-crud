package test.rpos;

import lombok.AllArgsConstructor;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Vorobyev Vyacheslav
 */
@Service
public abstract class CrudRepositoryImpl<L, R extends Record, T extends TableImpl<R>>
        implements CrudRepository<L, R> {

    protected DSLContext dsl;
    protected T table;
    protected String idFieldName;
    protected Map<String, UniqueKey<R>> uniqueKeyList;

    @Autowired
    public void setDslContext(DSLContext dslContext) {
        this.dsl = dslContext;
    }

    @PostConstruct
    private void init() {
        uniqueKeyList = new HashMap<>();
        table = initTable();
        idFieldName = initIdFieldName();
        var primaryKey = table.getPrimaryKey();
        if (primaryKey != null)
            uniqueKeyList.put(idFieldName, primaryKey);
        var keys = table.getUniqueKeys();
        uniqueKeyList.putAll(keys.stream()
                .collect(Collectors.toMap(
                        x -> x.getFields()
                                .stream()
                                .map(Field::getName)
                                .collect(Collectors.toList()),
                        x -> x)).entrySet()
                .stream()
                .flatMap(x -> x.getKey().stream().map(i -> new ConstraintEntry<>(i, x.getValue())))
                .collect(Collectors.toMap(x -> x.referenceColumnName, x -> x.uniqueKey)));
    }

    protected abstract String initIdFieldName();

    protected abstract T initTable();

    @Override
    public Optional<R> insert(R t) {
        var insertStep = dsl.insertInto(table).set(t).returningResult();
        var res = insertStep.fetchOne();
        return returnKey(t, res);
    }

    public Optional<R> saveOrUpdate(R t, String columnWithConstraint) {
        var uniqueKey = uniqueKeyList.get(columnWithConstraint);
        if (uniqueKey == null)
            throw new IllegalArgumentException(
                    "Constraint not present: " + columnWithConstraint);
        var insertStep = dsl.insertInto(table)
                .set(t)
                .onConflictOnConstraint(uniqueKey)
                .doUpdate()
                .set(t)
                .returningResult();
        var res = insertTransactional(insertStep);
        return returnKey(t, res);
    }

    public Optional<R> saveOrUpdate(R t) {
        var insertStep = dsl.insertInto(table)
                .set(t)
                .onDuplicateKeyUpdate()
                .set(t)
                .returningResult();
        var res = insertTransactional(insertStep);
        return returnKey(t, res);
    }

    @Transactional
    private Record insertTransactional(InsertResultStep<Record> insertStep) {
        return insertStep.fetchOne();
    }

    @SuppressWarnings("unchecked")
    private Optional<R> returnKey(R t, Record record) {
        if (record != null) {
            L val = (L) record.getValue(idFieldName);
            t.set(DSL.field(idFieldName), val);
            return Optional.of(t);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Integer update(R t) {
        return dsl.update(table)
                .set(t)
                .execute();
    }

    @Override
    public Optional<R> get(L id) {
        return Optional.ofNullable(
                dsl.selectFrom(table)
                        .where(DSL.field(idFieldName).eq(id))
                        .fetchOne());
    }

    @Override
    public Boolean delete(L id) {
        return dsl.delete(table)
                .where(DSL.field(idFieldName).eq(id))
                .execute() == 1;
    }

    public R createRecord() {
        return dsl.newRecord(table);
    }

    @AllArgsConstructor
    private static class ConstraintEntry<R extends Record> {
        private String referenceColumnName;
        private UniqueKey<R> uniqueKey;
    }
}