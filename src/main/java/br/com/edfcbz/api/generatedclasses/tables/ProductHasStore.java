/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables;


import br.com.edfcbz.api.generatedclasses.Apirest;
import br.com.edfcbz.api.generatedclasses.Indexes;
import br.com.edfcbz.api.generatedclasses.Keys;
import br.com.edfcbz.api.generatedclasses.tables.records.ProductHasStoreRecord;

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
public class ProductHasStore extends TableImpl<ProductHasStoreRecord> {

    private static final long serialVersionUID = -1949839606;

    /**
     * The reference instance of <code>apirest.product_has_store</code>
     */
    public static final ProductHasStore PRODUCT_HAS_STORE = new ProductHasStore();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductHasStoreRecord> getRecordType() {
        return ProductHasStoreRecord.class;
    }

    /**
     * The column <code>apirest.product_has_store.id</code>.
     */
    public final TableField<ProductHasStoreRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>apirest.product_has_store.product_id</code>.
     */
    public final TableField<ProductHasStoreRecord, Integer> PRODUCT_ID = createField("product_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>apirest.product_has_store.store_id</code>.
     */
    public final TableField<ProductHasStoreRecord, Integer> STORE_ID = createField("store_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>apirest.product_has_store</code> table reference
     */
    public ProductHasStore() {
        this(DSL.name("product_has_store"), null);
    }

    /**
     * Create an aliased <code>apirest.product_has_store</code> table reference
     */
    public ProductHasStore(String alias) {
        this(DSL.name(alias), PRODUCT_HAS_STORE);
    }

    /**
     * Create an aliased <code>apirest.product_has_store</code> table reference
     */
    public ProductHasStore(Name alias) {
        this(alias, PRODUCT_HAS_STORE);
    }

    private ProductHasStore(Name alias, Table<ProductHasStoreRecord> aliased) {
        this(alias, aliased, null);
    }

    private ProductHasStore(Name alias, Table<ProductHasStoreRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.PRODUCT_HAS_STORE_FK_PRODUCT_HAS_STORE_PRODUCT1_IDX, Indexes.PRODUCT_HAS_STORE_FK_PRODUCT_HAS_STORE_STORE1_IDX, Indexes.PRODUCT_HAS_STORE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ProductHasStoreRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PRODUCT_HAS_STORE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ProductHasStoreRecord> getPrimaryKey() {
        return Keys.KEY_PRODUCT_HAS_STORE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ProductHasStoreRecord>> getKeys() {
        return Arrays.<UniqueKey<ProductHasStoreRecord>>asList(Keys.KEY_PRODUCT_HAS_STORE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ProductHasStoreRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ProductHasStoreRecord, ?>>asList(Keys.FK_PRODUCT_HAS_STORE_PRODUCT1, Keys.FK_PRODUCT_HAS_STORE_STORE1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductHasStore as(String alias) {
        return new ProductHasStore(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductHasStore as(Name alias) {
        return new ProductHasStore(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ProductHasStore rename(String name) {
        return new ProductHasStore(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ProductHasStore rename(Name name) {
        return new ProductHasStore(name, null);
    }
}