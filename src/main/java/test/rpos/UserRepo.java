package test.rpos;

import org.springframework.stereotype.Service;
import test.tables.Users;
import test.tables.records.UsersRecord;

/**
 * @author Vorobyev Vyacheslav
 */
@Service
public class UserRepo extends CrudRepositoryImpl<Long, UsersRecord, Users> {

    @Override
    protected String initIdFieldName() {
        return Users.USERS.ID.getName();
    }

    @Override
    protected Users initTable() {
        return Users.USERS;
    }
}