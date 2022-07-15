package test.rpos;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import test.ent.UniqueEnt;
import test.tables.UniqueTest;

/**
 * @author Vorobyev Vyacheslav
 */
@Service
@RequiredArgsConstructor
public class UniqueRepo {
    private final UniqueTest table = UniqueTest.UNIQUE_TEST;
    private final DSLContext dsl;

    public UniqueEnt insert(UniqueEnt uniqueEnt) {
        return dsl.insertInto(UniqueTest.UNIQUE_TEST)
                .set(table.NAME, uniqueEnt.getName())
                .set(table.VAL, uniqueEnt.getVal())
                .onConflict(table.VAL)
                .doUpdate()
                .set(table.NAME, uniqueEnt.getName())
                .set(table.VAL, uniqueEnt.getVal())
                .returningResult()
                .fetchOneInto(UniqueEnt.class);
    }
}