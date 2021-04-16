/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables.records;


import br.com.edfcbz.api.generatedclasses.tables.Store;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class StoreRecord extends UpdatableRecordImpl<StoreRecord> implements Record6<Integer, String, byte[], Double, Double, Integer> {

    private static final long serialVersionUID = -2070575830;

    /**
     * Setter for <code>apirest.store.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>apirest.store.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>apirest.store.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>apirest.store.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>apirest.store.logo</code>.
     */
    public void setLogo(byte... value) {
        set(2, value);
    }

    /**
     * Getter for <code>apirest.store.logo</code>.
     */
    public byte[] getLogo() {
        return (byte[]) get(2);
    }

    /**
     * Setter for <code>apirest.store.deliveryFee</code>.
     */
    public void setDeliveryfee(Double value) {
        set(3, value);
    }

    /**
     * Getter for <code>apirest.store.deliveryFee</code>.
     */
    public Double getDeliveryfee() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>apirest.store.deliveryFeeFreeOver</code>.
     */
    public void setDeliveryfeefreeover(Double value) {
        set(4, value);
    }

    /**
     * Getter for <code>apirest.store.deliveryFeeFreeOver</code>.
     */
    public Double getDeliveryfeefreeover() {
        return (Double) get(4);
    }

    /**
     * Setter for <code>apirest.store.status_store_id</code>.
     */
    public void setStatusStoreId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>apirest.store.status_store_id</code>.
     */
    public Integer getStatusStoreId() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, byte[], Double, Double, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, byte[], Double, Double, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Store.STORE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Store.STORE.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field3() {
        return Store.STORE.LOGO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field4() {
        return Store.STORE.DELIVERYFEE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field5() {
        return Store.STORE.DELIVERYFEEFREEOVER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Store.STORE.STATUS_STORE_ID;
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
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] component3() {
        return getLogo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component4() {
        return getDeliveryfee();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component5() {
        return getDeliveryfeefreeover();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getStatusStoreId();
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
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value3() {
        return getLogo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value4() {
        return getDeliveryfee();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value5() {
        return getDeliveryfeefreeover();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getStatusStoreId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreRecord value3(byte... value) {
        setLogo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreRecord value4(Double value) {
        setDeliveryfee(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreRecord value5(Double value) {
        setDeliveryfeefreeover(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreRecord value6(Integer value) {
        setStatusStoreId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreRecord values(Integer value1, String value2, byte[] value3, Double value4, Double value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StoreRecord
     */
    public StoreRecord() {
        super(Store.STORE);
    }

    /**
     * Create a detached, initialised StoreRecord
     */
    public StoreRecord(Integer id, String name, byte[] logo, Double deliveryfee, Double deliveryfeefreeover, Integer statusStoreId) {
        super(Store.STORE);

        set(0, id);
        set(1, name);
        set(2, logo);
        set(3, deliveryfee);
        set(4, deliveryfeefreeover);
        set(5, statusStoreId);
    }
}