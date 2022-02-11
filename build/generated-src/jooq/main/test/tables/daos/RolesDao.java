/*
 * This file is generated by jOOQ.
 */
package test.tables.daos;


import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import test.tables.Roles;
import test.tables.records.RolesRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RolesDao extends DAOImpl<RolesRecord, test.tables.pojos.Roles, Long> {

    /**
     * Create a new RolesDao without any configuration
     */
    public RolesDao() {
        super(Roles.ROLES, test.tables.pojos.Roles.class);
    }

    /**
     * Create a new RolesDao with an attached configuration
     */
    public RolesDao(Configuration configuration) {
        super(Roles.ROLES, test.tables.pojos.Roles.class, configuration);
    }

    @Override
    public Long getId(test.tables.pojos.Roles object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<test.tables.pojos.Roles> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Roles.ROLES.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<test.tables.pojos.Roles> fetchById(Long... values) {
        return fetch(Roles.ROLES.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public test.tables.pojos.Roles fetchOneById(Long value) {
        return fetchOne(Roles.ROLES.ID, value);
    }

    /**
     * Fetch records that have <code>code BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<test.tables.pojos.Roles> fetchRangeOfCode(String lowerInclusive, String upperInclusive) {
        return fetchRange(Roles.ROLES.CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>code IN (values)</code>
     */
    public List<test.tables.pojos.Roles> fetchByCode(String... values) {
        return fetch(Roles.ROLES.CODE, values);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<test.tables.pojos.Roles> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Roles.ROLES.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<test.tables.pojos.Roles> fetchByName(String... values) {
        return fetch(Roles.ROLES.NAME, values);
    }
}