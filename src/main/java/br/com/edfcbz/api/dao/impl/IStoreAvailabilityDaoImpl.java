/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.edfcbz.api.bean.StoreAvailability;
import br.com.edfcbz.api.idao.IStoreAvailabilityDao;

/**
 *
 * @author Eduardo
 */
public class IStoreAvailabilityDaoImpl extends GenericDao implements IStoreAvailabilityDao {

    //@Override
    public StoreAvailability save(StoreAvailability param) throws Throwable {
        return null;//0;// getDbContext().newRecord(STOREAVAILABILITY, param).store();
    }

    //@Override
    public StoreAvailability update(StoreAvailability param) throws Throwable {
        return null;
    }

    //@Override
    public int delete(StoreAvailability param) throws Throwable {
        return delete(param.getStoreId(), param.getAvailabilityId());
    }

    public int delete(Integer param1, Integer param2) throws Throwable {
		return 0;/*
					 * getDbContext().delete(STOREAVAILABILITY)
					 * .where(STOREAVAILABILITY.STOREID.eq(param1)
					 * .and(STOREAVAILABILITY.AVAILABILITYID.eq(param2))) .execute();
					 */
    }

    //@Override
    public int delete(Integer param) throws Throwable {
        return -1;
    }

    //@Override
    public StoreAvailability findById(Integer param) throws Throwable {
        return null;
    }

    //@Override
    public List<StoreAvailability> findByName(String param) throws Throwable {
        return new ArrayList<StoreAvailability>();
    }

    //@Override
    public List<StoreAvailability> findAll() throws Throwable {
        return null;// getDbContext().select().from(STOREAVAILABILITY).fetch().into(StoreAvailability.class);
    }

}
