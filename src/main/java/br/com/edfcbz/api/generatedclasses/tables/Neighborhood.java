/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables;


import br.com.edfcbz.api.generatedclasses.Apirest;
import br.com.edfcbz.api.generatedclasses.Indexes;
import br.com.edfcbz.api.generatedclasses.Keys;
import br.com.edfcbz.api.generatedclasses.tables.records.NeighborhoodRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class Neighborhood extends TableImpl<NeighborhoodRecord> {

    private static final long serialVersionUID = 1083094715;

    /**
     * The reference instance of <code>apirest.neighborhood</code>
     */
    public static final Neighborhood NEIGHBORHOOD = new Neighborhood();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NeighborhoodRecord> getRecordType() {
        return NeighborhoodRecord.class;
    }

    /**
     * The column <code>apirest.neighborhood.id</code>.
     */
    public final TableField<NeighborhoodRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>apirest.neighborhood.neighborhood</code>.
     */
    public final TableField<NeighborhoodRecord, String> NEIGHBORHOOD_ = createField("neighborhood", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * Create a <code>apirest.neighborhood</code> table reference
     */
    public Neighborhood() {
        this(DSL.name("neighborhood"), null);
    }

    /**
     * Create an aliased <code>apirest.neighborhood</code> table reference
     */
    public Neighborhood(String alias) {
        this(DSL.name(alias), NEIGHBORHOOD);
    }

    /**
     * Create an aliased <code>apirest.neighborhood</code> table reference
     */
    public Neighborhood(Name alias) {
        this(alias, NEIGHBORHOOD);
    }

    private Neighborhood(Name alias, Table<NeighborhoodRecord> aliased) {
        this(alias, aliased, null);
    }

    private Neighborhood(Name alias, Table<NeighborhoodRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.NEIGHBORHOOD_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<NeighborhoodRecord, Integer> getIdentity() {
        return Keys.IDENTITY_NEIGHBORHOOD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<NeighborhoodRecord> getPrimaryKey() {
        return Keys.KEY_NEIGHBORHOOD_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<NeighborhoodRecord>> getKeys() {
        return Arrays.<UniqueKey<NeighborhoodRecord>>asList(Keys.KEY_NEIGHBORHOOD_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Neighborhood as(String alias) {
        return new Neighborhood(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Neighborhood as(Name alias) {
        return new Neighborhood(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Neighborhood rename(String name) {
        return new Neighborhood(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Neighborhood rename(Name name) {
        return new Neighborhood(name, null);
    }
}
