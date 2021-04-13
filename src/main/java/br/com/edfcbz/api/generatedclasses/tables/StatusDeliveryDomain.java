/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables;


import br.com.edfcbz.api.generatedclasses.Apirest;
import br.com.edfcbz.api.generatedclasses.Indexes;
import br.com.edfcbz.api.generatedclasses.Keys;
import br.com.edfcbz.api.generatedclasses.tables.records.StatusDeliveryDomainRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StatusDeliveryDomain extends TableImpl<StatusDeliveryDomainRecord> {

    private static final long serialVersionUID = -227817439;

    /**
     * The reference instance of <code>apirest.status_delivery_domain</code>
     */
    public static final StatusDeliveryDomain STATUS_DELIVERY_DOMAIN = new StatusDeliveryDomain();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StatusDeliveryDomainRecord> getRecordType() {
        return StatusDeliveryDomainRecord.class;
    }

    /**
     * The column <code>apirest.status_delivery_domain.id</code>.
     */
    public final TableField<StatusDeliveryDomainRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>apirest.status_delivery_domain.name</code>.
     */
    public final TableField<StatusDeliveryDomainRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * Create a <code>apirest.status_delivery_domain</code> table reference
     */
    public StatusDeliveryDomain() {
        this(DSL.name("status_delivery_domain"), null);
    }

    /**
     * Create an aliased <code>apirest.status_delivery_domain</code> table reference
     */
    public StatusDeliveryDomain(String alias) {
        this(DSL.name(alias), STATUS_DELIVERY_DOMAIN);
    }

    /**
     * Create an aliased <code>apirest.status_delivery_domain</code> table reference
     */
    public StatusDeliveryDomain(Name alias) {
        this(alias, STATUS_DELIVERY_DOMAIN);
    }

    private StatusDeliveryDomain(Name alias, Table<StatusDeliveryDomainRecord> aliased) {
        this(alias, aliased, null);
    }

    private StatusDeliveryDomain(Name alias, Table<StatusDeliveryDomainRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Apirest.APIREST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.STATUS_DELIVERY_DOMAIN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<StatusDeliveryDomainRecord, Integer> getIdentity() {
        return Keys.IDENTITY_STATUS_DELIVERY_DOMAIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StatusDeliveryDomainRecord> getPrimaryKey() {
        return Keys.KEY_STATUS_DELIVERY_DOMAIN_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StatusDeliveryDomainRecord>> getKeys() {
        return Arrays.<UniqueKey<StatusDeliveryDomainRecord>>asList(Keys.KEY_STATUS_DELIVERY_DOMAIN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusDeliveryDomain as(String alias) {
        return new StatusDeliveryDomain(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusDeliveryDomain as(Name alias) {
        return new StatusDeliveryDomain(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StatusDeliveryDomain rename(String name) {
        return new StatusDeliveryDomain(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public StatusDeliveryDomain rename(Name name) {
        return new StatusDeliveryDomain(name, null);
    }
}
