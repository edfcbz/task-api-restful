/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.edfcbz.api.bean.CourrierAvailability;
import br.com.edfcbz.api.idao.ICourrierAvailabilityDao;


/**
 *
 * @author Eduardo
 */
public class ICourrierAvailabilityDaoImpl extends GenericDao implements ICourrierAvailabilityDao {

    //@Override
    public CourrierAvailability save(CourrierAvailability param) throws Throwable {
        return null;//0;//getDbContext().newRecord(COURRIERAVAILABILITY, param).store();
    }

    //@Override
    public CourrierAvailability update(CourrierAvailability param) throws Throwable {
        return null;
    }

    //@Override
    public int delete(CourrierAvailability param) throws Throwable {
        System.out.println("ICourrierAvailabilityDaoImpl.delete()");
//        return getDbContext().delete(COURRIERAVAILABILITY)
//                .where(COURRIERAVAILABILITY.COURRIERID.eq(param.getCourrierId()))
//                .and(COURRIERAVAILABILITY.AVAILABILITYID.eq(param.getAvailabilityId()))
//                .execute();
        return 0;
    }

    //@Override
    public int delete(Integer param) throws Throwable {
        return -1;
    }

    //@Override
    public CourrierAvailability findById(Integer param) throws Throwable {
        return null;// new ArrayList<CourrierAvailability>();
    }

    //@Override
    public List<CourrierAvailability> findByName(String param) throws Throwable {
        return new ArrayList<CourrierAvailability>();
    }

    //@Override
    public List<CourrierAvailability> findAll() throws Throwable {
        return new ArrayList<CourrierAvailability>();//getDbContext().select().from(COURRIERAVAILABILITY).fetch().into(CourrierAvailability.class);
    }

}
