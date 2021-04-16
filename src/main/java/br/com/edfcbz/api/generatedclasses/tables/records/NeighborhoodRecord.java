/*
 * This file is generated by jOOQ.
*/
package br.com.edfcbz.api.generatedclasses.tables.records;


import br.com.edfcbz.api.generatedclasses.tables.Neighborhood;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class NeighborhoodRecord extends UpdatableRecordImpl<NeighborhoodRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1865949928;

    /**
     * Setter for <code>apirest.neighborhood.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>apirest.neighborhood.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>apirest.neighborhood.neighborhood</code>.
     */
    public void setNeighborhood(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>apirest.neighborhood.neighborhood</code>.
     */
    public String getNeighborhood() {
        return (String) get(1);
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
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Neighborhood.NEIGHBORHOOD.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Neighborhood.NEIGHBORHOOD.NEIGHBORHOOD_;
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
        return getNeighborhood();
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
        return getNeighborhood();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NeighborhoodRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NeighborhoodRecord value2(String value) {
        setNeighborhood(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NeighborhoodRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached NeighborhoodRecord
     */
    public NeighborhoodRecord() {
        super(Neighborhood.NEIGHBORHOOD);
    }

    /**
     * Create a detached, initialised NeighborhoodRecord
     */
    public NeighborhoodRecord(Integer id, String neighborhood) {
        super(Neighborhood.NEIGHBORHOOD);

        set(0, id);
        set(1, neighborhood);
    }
}