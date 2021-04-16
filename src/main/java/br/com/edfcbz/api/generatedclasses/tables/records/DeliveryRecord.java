/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables.records;


import br.com.edfcbz.api.generatedclasses.tables.Delivery;

import java.sql.Timestamp;

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
public class DeliveryRecord extends UpdatableRecordImpl<DeliveryRecord> implements Record3<Integer, Integer, Timestamp> {

    private static final long serialVersionUID = -240633399;

    /**
     * Setter for <code>apirest.delivery.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>apirest.delivery.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>apirest.delivery.courrier_id</code>.
     */
    public void setCourrierId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>apirest.delivery.courrier_id</code>.
     */
    public Integer getCourrierId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>apirest.delivery.update</code>.
     */
    public void setUpdate(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>apirest.delivery.update</code>.
     */
    public Timestamp getUpdate() {
        return (Timestamp) get(2);
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
    public Row3<Integer, Integer, Timestamp> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Timestamp> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Delivery.DELIVERY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Delivery.DELIVERY.COURRIER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Delivery.DELIVERY.UPDATE;
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
        return getCourrierId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getUpdate();
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
        return getCourrierId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeliveryRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeliveryRecord value2(Integer value) {
        setCourrierId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeliveryRecord value3(Timestamp value) {
        setUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeliveryRecord values(Integer value1, Integer value2, Timestamp value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DeliveryRecord
     */
    public DeliveryRecord() {
        super(Delivery.DELIVERY);
    }

    /**
     * Create a detached, initialised DeliveryRecord
     */
    public DeliveryRecord(Integer id, Integer courrierId, Timestamp update) {
        super(Delivery.DELIVERY);

        set(0, id);
        set(1, courrierId);
        set(2, update);
    }
}