/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

//import static ca.skipthedishes.mysql.generatedclasses.Tables.AVAILABILITY;
import java.util.ArrayList;
import java.util.List;

import br.com.edfcbz.api.bean.Availability;
import br.com.edfcbz.api.idao.IAvailabilityDao;

/**
 *
 * @author Eduardo
 */
public class IAvailabilityDaoImpl extends GenericDao implements IAvailabilityDao {

    //@Override
    public Availability save(Availability param) throws Throwable {
        return null;// 0;//getDbContext().newRecord(AVAILABILITY, param).store();
    }

    //@Override
    public Availability update(Availability param) throws Throwable {
//        return getDbContext().update(AVAILABILITY)
//                .set(AVAILABILITY.DATEINITIAL, param.getDateInitial())
//                .set(AVAILABILITY.DATEFINAL, param.getDateFinal())
//                .where(AVAILABILITY.ID.eq(param.getId()))
//                .execute();
        return null;//;
    }

    //@Override
    public int delete(Availability param) throws Throwable {
        return delete(param.getId());
    }

    //@Override
    public int delete(Integer param) throws Throwable {
        return 0;// getDbContext().fetchOne(AVAILABILITY, AVAILABILITY.ID.eq(param)).delete();
    }

    //@Override
    public Availability findById(Integer param) throws Throwable {
        return null;// getDbContext().fetch(AVAILABILITY, AVAILABILITY.ID.eq(param)).into(Availability.class);
    }

    //@Override
    public List<Availability> findByName(String param) throws Throwable {
        return new ArrayList<Availability>();
    }

    //@Override
    public List<Availability> findAll() throws Throwable {
        return null;//getDbContext().select().from(AVAILABILITY).fetch().into(Availability.class);
    }

}
