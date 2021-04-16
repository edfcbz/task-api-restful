/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables;


import br.com.edfcbz.api.generatedclasses.Apirest;
import br.com.edfcbz.api.generatedclasses.Indexes;
import br.com.edfcbz.api.generatedclasses.Keys;
import br.com.edfcbz.api.generatedclasses.tables.records.CustomerHasAddressRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class CustomerHasAddress extends TableImpl<CustomerHasAddressRecord> {

    private static final long serialVersionUID = 1848269737;

    /**
     * The reference instance of <code>apirest.customer_has_address</code>
     */
    public static final CustomerHasAddress CUSTOMER_HAS_ADDRESS = new CustomerHasAddress();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CustomerHasAddressRecord> getRecordType() {
        return CustomerHasAddressRecord.class;
    }

    /**
     * The column <code>apirest.customer_has_address.id</code>.
     */
    public final TableField<CustomerHasAddressRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>apirest.customer_has_address.address_id</code>.
     */
    public final TableField<CustomerHasAddressRecord, Integer> ADDRESS_ID = createField("address_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>apirest.customer_has_address.type_address_id</code>.
     */
    public final TableField<CustomerHasAddressRecord, Integer> TYPE_ADDRESS_ID = createField("type_address_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>apirest.customer_has_address.customer_id</code>.
     */
    public final TableField<CustomerHasAddressRecord, Integer> CUSTOMER_ID = createField("customer_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>apirest.customer_has_address</code> table reference
     */
    public CustomerHasAddress() {
        this(DSL.name("customer_has_address"), null);
    }

    /**
     * Create an aliased <code>apirest.customer_has_address</code> table reference
     */
    public CustomerHasAddress(String alias) {
        this(DSL.name(alias), CUSTOMER_HAS_ADDRESS);
    }

    /**
     * Create an aliased <code>apirest.customer_has_address</code> table reference
     */
    public CustomerHasAddress(Name alias) {
        this(alias, CUSTOMER_HAS_ADDRESS);
    }

    private CustomerHasAddress(Name alias, Table<CustomerHasAddressRecord> aliased) {
        this(alias, aliased, null);
    }

    private CustomerHasAddress(Name alias, Table<CustomerHasAddressRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CUSTOMER_HAS_ADDRESS_FK_CUSTOMER_HAS_ADDRESS_ADDRESS1_IDX, Indexes.CUSTOMER_HAS_ADDRESS_FK_CUSTOMER_HAS_ADDRESS_CUSTOMER1_IDX, Indexes.CUSTOMER_HAS_ADDRESS_FK_CUSTOMER_HAS_ADDRESS_TYPE_ADDRESS1_IDX, Indexes.CUSTOMER_HAS_ADDRESS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CustomerHasAddressRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CUSTOMER_HAS_ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CustomerHasAddressRecord> getPrimaryKey() {
        return Keys.KEY_CUSTOMER_HAS_ADDRESS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CustomerHasAddressRecord>> getKeys() {
        return Arrays.<UniqueKey<CustomerHasAddressRecord>>asList(Keys.KEY_CUSTOMER_HAS_ADDRESS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<CustomerHasAddressRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CustomerHasAddressRecord, ?>>asList(Keys.FK_CUSTOMER_HAS_ADDRESS_ADDRESS1, Keys.FK_CUSTOMER_HAS_ADDRESS_TYPE_ADDRESS1, Keys.FK_CUSTOMER_HAS_ADDRESS_CUSTOMER1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerHasAddress as(String alias) {
        return new CustomerHasAddress(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerHasAddress as(Name alias) {
        return new CustomerHasAddress(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CustomerHasAddress rename(String name) {
        return new CustomerHasAddress(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CustomerHasAddress rename(Name name) {
        return new CustomerHasAddress(name, null);
    }
}