/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables;


import br.com.edfcbz.api.generatedclasses.Apirest;
import br.com.edfcbz.api.generatedclasses.Indexes;
import br.com.edfcbz.api.generatedclasses.Keys;
import br.com.edfcbz.api.generatedclasses.tables.records.ProvinceRecord;

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
public class Province extends TableImpl<ProvinceRecord> {

    private static final long serialVersionUID = 1475951047;

    /**
     * The reference instance of <code>apirest.province</code>
     */
    public static final Province PROVINCE = new Province();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProvinceRecord> getRecordType() {
        return ProvinceRecord.class;
    }

    /**
     * The column <code>apirest.province.id</code>.
     */
    public final TableField<ProvinceRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>apirest.province.name</code>.
     */
    public final TableField<ProvinceRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>apirest.province.sigle</code>.
     */
    public final TableField<ProvinceRecord, String> SIGLE = createField("sigle", org.jooq.impl.SQLDataType.VARCHAR(5).nullable(false), this, "");

    /**
     * The column <code>apirest.province.country_id</code>.
     */
    public final TableField<ProvinceRecord, Integer> COUNTRY_ID = createField("country_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>apirest.province</code> table reference
     */
    public Province() {
        this(DSL.name("province"), null);
    }

    /**
     * Create an aliased <code>apirest.province</code> table reference
     */
    public Province(String alias) {
        this(DSL.name(alias), PROVINCE);
    }

    /**
     * Create an aliased <code>apirest.province</code> table reference
     */
    public Province(Name alias) {
        this(alias, PROVINCE);
    }

    private Province(Name alias, Table<ProvinceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Province(Name alias, Table<ProvinceRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.PROVINCE_FK_PROVINCE_COUNTRY1_IDX, Indexes.PROVINCE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ProvinceRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PROVINCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ProvinceRecord> getPrimaryKey() {
        return Keys.KEY_PROVINCE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ProvinceRecord>> getKeys() {
        return Arrays.<UniqueKey<ProvinceRecord>>asList(Keys.KEY_PROVINCE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ProvinceRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ProvinceRecord, ?>>asList(Keys.FK_PROVINCE_COUNTRY1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Province as(String alias) {
        return new Province(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Province as(Name alias) {
        return new Province(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Province rename(String name) {
        return new Province(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Province rename(Name name) {
        return new Province(name, null);
    }
}
