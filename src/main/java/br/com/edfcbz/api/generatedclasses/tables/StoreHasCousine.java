/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables;


import br.com.edfcbz.api.generatedclasses.Apirest;
import br.com.edfcbz.api.generatedclasses.Indexes;
import br.com.edfcbz.api.generatedclasses.Keys;
import br.com.edfcbz.api.generatedclasses.tables.records.StoreHasCousineRecord;

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
public class StoreHasCousine extends TableImpl<StoreHasCousineRecord> {

    private static final long serialVersionUID = 1186146331;

    /**
     * The reference instance of <code>apirest.store_has_cousine</code>
     */
    public static final StoreHasCousine STORE_HAS_COUSINE = new StoreHasCousine();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StoreHasCousineRecord> getRecordType() {
        return StoreHasCousineRecord.class;
    }

    /**
     * The column <code>apirest.store_has_cousine.id</code>.
     */
    public final TableField<StoreHasCousineRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>apirest.store_has_cousine.storeId</code>.
     */
    public final TableField<StoreHasCousineRecord, Integer> STOREID = createField("storeId", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>apirest.store_has_cousine.cousine_id</code>.
     */
    public final TableField<StoreHasCousineRecord, Integer> COUSINE_ID = createField("cousine_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>apirest.store_has_cousine.isMain</code>.
     */
    public final TableField<StoreHasCousineRecord, Byte> ISMAIN = createField("isMain", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * Create a <code>apirest.store_has_cousine</code> table reference
     */
    public StoreHasCousine() {
        this(DSL.name("store_has_cousine"), null);
    }

    /**
     * Create an aliased <code>apirest.store_has_cousine</code> table reference
     */
    public StoreHasCousine(String alias) {
        this(DSL.name(alias), STORE_HAS_COUSINE);
    }

    /**
     * Create an aliased <code>apirest.store_has_cousine</code> table reference
     */
    public StoreHasCousine(Name alias) {
        this(alias, STORE_HAS_COUSINE);
    }

    private StoreHasCousine(Name alias, Table<StoreHasCousineRecord> aliased) {
        this(alias, aliased, null);
    }

    private StoreHasCousine(Name alias, Table<StoreHasCousineRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.STORE_HAS_COUSINE_FK_STORE_HAS_COUSINE_COUSINE1_IDX, Indexes.STORE_HAS_COUSINE_FK_STORE_HAS_COUSINE_STORE1_IDX, Indexes.STORE_HAS_COUSINE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<StoreHasCousineRecord, Integer> getIdentity() {
        return Keys.IDENTITY_STORE_HAS_COUSINE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StoreHasCousineRecord> getPrimaryKey() {
        return Keys.KEY_STORE_HAS_COUSINE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StoreHasCousineRecord>> getKeys() {
        return Arrays.<UniqueKey<StoreHasCousineRecord>>asList(Keys.KEY_STORE_HAS_COUSINE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<StoreHasCousineRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<StoreHasCousineRecord, ?>>asList(Keys.FK_STORE_HAS_COUSINE_STORE1, Keys.FK_STORE_HAS_COUSINE_COUSINE1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreHasCousine as(String alias) {
        return new StoreHasCousine(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreHasCousine as(Name alias) {
        return new StoreHasCousine(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StoreHasCousine rename(String name) {
        return new StoreHasCousine(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public StoreHasCousine rename(Name name) {
        return new StoreHasCousine(name, null);
    }
}
