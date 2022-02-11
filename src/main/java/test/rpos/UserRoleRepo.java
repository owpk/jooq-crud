package test.rpos;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.tables.RoleUser;
import test.tables.daos.RoleUserDao;
import test.tables.records.RoleUserRecord;

import java.util.List;

/**
 * @author Vorobyev Vyacheslav
 */
@Service
@RequiredArgsConstructor
public class UserRoleRepo extends  CrudRepositoryImpl<Long, RoleUserRecord, RoleUser> {
    private final DSLContext dsl;
    private RoleUserDao roleUserDao;

    @Transactional
    public int insertUserRoleRecord(Long userId, List<Long> roleIds) {
        Result<RoleUserRecord> records = dsl.fetch(table);
        for (Long roleId: roleIds) {
            var rec = dsl.fetchOne(
                    table, table.ROLEID.eq(roleId).and(table.USERID.eq(userId)));
            if (rec == null) {
                rec = createRecord();
                rec.setUserid(userId);
                rec.setRoleid(roleId);
                records.add(rec);
            }
        }
        return  dsl.batchStore(records).execute().length;
    }

    @Override
    protected String initIdFieldName() {
        return "id";
    }

    @Override
    protected RoleUser initTable() {
        return RoleUser.ROLE_USER;
    }
}
