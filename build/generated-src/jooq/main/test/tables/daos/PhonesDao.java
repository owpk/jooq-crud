/*
 * This file is generated by jOOQ.
 */
package test.tables.daos;


import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import test.tables.Phones;
import test.tables.records.PhonesRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PhonesDao extends DAOImpl<PhonesRecord, test.tables.pojos.Phones, Long> {

    /**
     * Create a new PhonesDao without any configuration
     */
    public PhonesDao() {
        super(Phones.PHONES, test.tables.pojos.Phones.class);
    }

    /**
     * Create a new PhonesDao with an attached configuration
     */
    public PhonesDao(Configuration configuration) {
        super(Phones.PHONES, test.tables.pojos.Phones.class, configuration);
    }

    @Override
    public Long getId(test.tables.pojos.Phones object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<test.tables.pojos.Phones> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Phones.PHONES.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<test.tables.pojos.Phones> fetchById(Long... values) {
        return fetch(Phones.PHONES.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public test.tables.pojos.Phones fetchOneById(Long value) {
        return fetchOne(Phones.PHONES.ID, value);
    }

    /**
     * Fetch records that have <code>type BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<test.tables.pojos.Phones> fetchRangeOfType(String lowerInclusive, String upperInclusive) {
        return fetchRange(Phones.PHONES.TYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<test.tables.pojos.Phones> fetchByType(String... values) {
        return fetch(Phones.PHONES.TYPE, values);
    }
}
