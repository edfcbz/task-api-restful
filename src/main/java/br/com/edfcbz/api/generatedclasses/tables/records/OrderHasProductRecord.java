/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables.records;


import br.com.edfcbz.api.generatedclasses.tables.OrderHasProduct;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class OrderHasProductRecord extends UpdatableRecordImpl<OrderHasProductRecord> implements Record4<Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = 2137124219;

    /**
     * Setter for <code>apirest.order_has_product.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>apirest.order_has_product.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>apirest.order_has_product.order_id</code>.
     */
    public void setOrderId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>apirest.order_has_product.order_id</code>.
     */
    public Integer getOrderId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>apirest.order_has_product.product_id</code>.
     */
    public void setProductId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>apirest.order_has_product.product_id</code>.
     */
    public Integer getProductId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>apirest.order_has_product.quantity</code>.
     */
    public void setQuantity(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>apirest.order_has_product.quantity</code>.
     */
    public Integer getQuantity() {
        return (Integer) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return OrderHasProduct.ORDER_HAS_PRODUCT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return OrderHasProduct.ORDER_HAS_PRODUCT.ORDER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return OrderHasProduct.ORDER_HAS_PRODUCT.PRODUCT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return OrderHasProduct.ORDER_HAS_PRODUCT.QUANTITY;
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
        return getProductId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getQuantity();
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
        return getProductId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getQuantity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderHasProductRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderHasProductRecord value2(Integer value) {
        setOrderId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderHasProductRecord value3(Integer value) {
        setProductId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderHasProductRecord value4(Integer value) {
        setQuantity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderHasProductRecord values(Integer value1, Integer value2, Integer value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrderHasProductRecord
     */
    public OrderHasProductRecord() {
        super(OrderHasProduct.ORDER_HAS_PRODUCT);
    }

    /**
     * Create a detached, initialised OrderHasProductRecord
     */
    public OrderHasProductRecord(Integer id, Integer orderId, Integer productId, Integer quantity) {
        super(OrderHasProduct.ORDER_HAS_PRODUCT);

        set(0, id);
        set(1, orderId);
        set(2, productId);
        set(3, quantity);
    }
}