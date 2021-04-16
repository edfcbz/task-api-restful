/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables;


import br.com.edfcbz.api.generatedclasses.Apirest;
import br.com.edfcbz.api.generatedclasses.Indexes;
import br.com.edfcbz.api.generatedclasses.Keys;
import br.com.edfcbz.api.generatedclasses.tables.records.OrderStoreRecord;

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
public class OrderStore extends TableImpl<OrderStoreRecord> {

    private static final long serialVersionUID = -174873536;

    /**
     * The reference instance of <code>apirest.order_store</code>
     */
    public static final OrderStore ORDER_STORE = new OrderStore();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrderStoreRecord> getRecordType() {
        return OrderStoreRecord.class;
    }

    /**
     * The column <code>apirest.order_store.id</code>.
     */
    public final TableField<OrderStoreRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>apirest.order_store.order_id</code>.
     */
    public final TableField<OrderStoreRecord, Integer> ORDER_ID = createField("order_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>apirest.order_store.store_id</code>.
     */
    public final TableField<OrderStoreRecord, Integer> STORE_ID = createField("store_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>apirest.order_store</code> table reference
     */
    public OrderStore() {
        this(DSL.name("order_store"), null);
    }

    /**
     * Create an aliased <code>apirest.order_store</code> table reference
     */
    public OrderStore(String alias) {
        this(DSL.name(alias), ORDER_STORE);
    }

    /**
     * Create an aliased <code>apirest.order_store</code> table reference
     */
    public OrderStore(Name alias) {
        this(alias, ORDER_STORE);
    }

    private OrderStore(Name alias, Table<OrderStoreRecord> aliased) {
        this(alias, aliased, null);
    }

    private OrderStore(Name alias, Table<OrderStoreRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.ORDER_STORE_FK_ORDER_HAS_STORE_ORDER1_IDX, Indexes.ORDER_STORE_FK_ORDER_HAS_STORE_STORE1_IDX, Indexes.ORDER_STORE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<OrderStoreRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ORDER_STORE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<OrderStoreRecord> getPrimaryKey() {
        return Keys.KEY_ORDER_STORE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<OrderStoreRecord>> getKeys() {
        return Arrays.<UniqueKey<OrderStoreRecord>>asList(Keys.KEY_ORDER_STORE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<OrderStoreRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<OrderStoreRecord, ?>>asList(Keys.FK_ORDER_HAS_STORE_ORDER1, Keys.FK_ORDER_HAS_STORE_STORE1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderStore as(String alias) {
        return new OrderStore(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderStore as(Name alias) {
        return new OrderStore(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderStore rename(String name) {
        return new OrderStore(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderStore rename(Name name) {
        return new OrderStore(name, null);
    }
}