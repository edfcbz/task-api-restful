/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables.records;


import br.com.edfcbz.api.generatedclasses.tables.Product;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class ProductRecord extends UpdatableRecordImpl<ProductRecord> implements Record5<Integer, String, String, Double, byte[]> {

    private static final long serialVersionUID = -117002083;

    /**
     * Setter for <code>apirest.product.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>apirest.product.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>apirest.product.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>apirest.product.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>apirest.product.description</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>apirest.product.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>apirest.product.price</code>.
     */
    public void setPrice(Double value) {
        set(3, value);
    }

    /**
     * Getter for <code>apirest.product.price</code>.
     */
    public Double getPrice() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>apirest.product.productImage</code>.
     */
    public void setProductimage(byte... value) {
        set(4, value);
    }

    /**
     * Getter for <code>apirest.product.productImage</code>.
     */
    public byte[] getProductimage() {
        return (byte[]) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, Double, byte[]> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, Double, byte[]> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Product.PRODUCT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Product.PRODUCT.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Product.PRODUCT.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field4() {
        return Product.PRODUCT.PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field5() {
        return Product.PRODUCT.PRODUCTIMAGE;
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
    public String component3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component4() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] component5() {
        return getProductimage();
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
    public String value3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value4() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value5() {
        return getProductimage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value3(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value4(Double value) {
        setPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value5(byte... value) {
        setProductimage(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord values(Integer value1, String value2, String value3, Double value4, byte[] value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProductRecord
     */
    public ProductRecord() {
        super(Product.PRODUCT);
    }

    /**
     * Create a detached, initialised ProductRecord
     */
    public ProductRecord(Integer id, String name, String description, Double price, byte[] productimage) {
        super(Product.PRODUCT);

        set(0, id);
        set(1, name);
        set(2, description);
        set(3, price);
        set(4, productimage);
    }
}
