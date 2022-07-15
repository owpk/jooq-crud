package test.rpos;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;
import test.ent.InnerInnerRecord;
import test.ent.InnerRecord;
import test.ent.Records;
import test.tables.InnerInnerRecords;
import test.tables.InnerRecords;
import test.tables.daos.RecordsDao;

import java.util.List;
import java.util.stream.Collectors;

import static org.jooq.impl.DSL.*;

/**
 * @author Vorobyev Vyacheslav
 */
@Service
@RequiredArgsConstructor
public class RecordsRepose implements RecordsReposeI {
    private final DSLContext dslContext;
    private RecordsDao recordsDao;

    @Override
    public void save(List<Records> records) {
        var table = test.tables.Records.RECORDS;
        var list = records.stream().map(x -> {
            var rec = dslContext.newRecord(table);
            rec.set(table.NAME, x.getName());
            return rec;
        }).collect(Collectors.toList());
        dslContext.batchMerge(list).execute();
    }

    @Override
    public void batchOnConflict(List<Records> list) {
        var table = test.tables.Records.RECORDS;
        var insert =
                dslContext.insertInto(table, table.NAME, table.DATA);
        for (var rec : list) {
            insert = insert.values(rec.getName(), rec.getData());
        }
        var result = insert.onConflict(table.NAME).doUpdate()
                .set(table.DATA, DSL.coalesce(table.as("excluded").DATA, table.DATA))
                .returningResult()
                .fetch().into(Records.class);
    }

    @Override
    public void select() {
        var table = test.tables.Records.RECORDS;
        var res = dslContext
                .select(table.ID,
                        table.DATA,
                        table.NAME,
                        multiset(DSL.select()
                                .from(InnerRecords.INNER_RECORDS)
                                .where(InnerRecords.INNER_RECORDS.ID.eq(table.INNERRECORDID))
                        ).convertFrom(r -> r.into(InnerRecords.INNER_RECORDS.fields())).as("innerRecord")
                ).from(table).fetchOneInto(Records.class);
    }

}