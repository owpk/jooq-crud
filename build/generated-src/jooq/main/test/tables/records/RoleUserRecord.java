/*
 * This file is generated by jOOQ.
 */
package test.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import test.tables.RoleUser;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RoleUserRecord extends UpdatableRecordImpl<RoleUserRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.role_user.id</code>.
     */
    public RoleUserRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.role_user.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.role_user.userId</code>.
     */
    public RoleUserRecord setUserid(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.role_user.userId</code>.
     */
    public Long getUserid() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.role_user.roleId</code>.
     */
    public RoleUserRecord setRoleid(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.role_user.roleId</code>.
     */
    public Long getRoleid() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return RoleUser.ROLE_USER.ID;
    }

    @Override
    public Field<Long> field2() {
        return RoleUser.ROLE_USER.USERID;
    }

    @Override
    public Field<Long> field3() {
        return RoleUser.ROLE_USER.ROLEID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getUserid();
    }

    @Override
    public Long component3() {
        return getRoleid();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getUserid();
    }

    @Override
    public Long value3() {
        return getRoleid();
    }

    @Override
    public RoleUserRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public RoleUserRecord value2(Long value) {
        setUserid(value);
        return this;
    }

    @Override
    public RoleUserRecord value3(Long value) {
        setRoleid(value);
        return this;
    }

    @Override
    public RoleUserRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RoleUserRecord
     */
    public RoleUserRecord() {
        super(RoleUser.ROLE_USER);
    }

    /**
     * Create a detached, initialised RoleUserRecord
     */
    public RoleUserRecord(Long id, Long userid, Long roleid) {
        super(RoleUser.ROLE_USER);

        setId(id);
        setUserid(userid);
        setRoleid(roleid);
    }

    /**
     * Create a detached, initialised RoleUserRecord
     */
    public RoleUserRecord(test.tables.pojos.RoleUser value) {
        super(RoleUser.ROLE_USER);

        if (value != null) {
            setId(value.getId());
            setUserid(value.getUserid());
            setRoleid(value.getRoleid());
        }
    }
}
