/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables.records;


import br.com.edfcbz.api.generatedclasses.tables.OrderStore;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


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
public class OrderStoreRecord extends UpdatableRecordImpl<OrderStoreRecord> implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = 468530284;

    /**
     * Setter for <code>apirest.order_store.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>apirest.order_store.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>apirest.order_store.order_id</code>.
     */
    public void setOrderId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>apirest.order_store.order_id</code>.
     */
    public Integer getOrderId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>apirest.order_store.store_id</code>.
     */
    public void setStoreId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>apirest.order_store.store_id</code>.
     */
    public Integer getStoreId() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return OrderStore.ORDER_STORE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return OrderStore.ORDER_STORE.ORDER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return OrderStore.ORDER_STORE.STORE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getOrderId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getStoreId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getOrderId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getStoreId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderStoreRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderStoreRecord value2(Integer value) {
        setOrderId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderStoreRecord value3(Integer value) {
        setStoreId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderStoreRecord values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrderStoreRecord
     */
    public OrderStoreRecord() {
        super(OrderStore.ORDER_STORE);
    }

    /**
     * Create a detached, initialised OrderStoreRecord
     */
    public OrderStoreRecord(Integer id, Integer orderId, Integer storeId) {
        super(OrderStore.ORDER_STORE);

        set(0, id);
        set(1, orderId);
        set(2, storeId);
    }
}
