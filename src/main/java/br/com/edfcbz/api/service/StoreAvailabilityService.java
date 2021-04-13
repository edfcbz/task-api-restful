/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service;

import br.com.edfcbz.api.bean.StoreAvailability;
import br.com.edfcbz.api.dao.impl.IStoreAvailabilityDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class StoreAvailabilityService implements IService<StoreAvailability>{

    @Override
    public StoreAvailability save(StoreAvailability param) throws Throwable {
        return new IStoreAvailabilityDaoImpl().save(param);
    }

    @Override
    public StoreAvailability update(StoreAvailability param) throws Throwable {
        return new IStoreAvailabilityDaoImpl().update(param);
    }

    @Override
    public int delete(StoreAvailability param) throws Throwable {
        return new IStoreAvailabilityDaoImpl().delete(param);
    }

    @Override
    public int delete(Integer param) throws Throwable {
       return new IStoreAvailabilityDaoImpl().delete(param);
    }

    @Override
    public StoreAvailability findById(Integer param) throws Throwable {
        return new IStoreAvailabilityDaoImpl().findById(param);
    }

    @Override
    public List<StoreAvailability> findByName(String param){
       return new ArrayList<>();
    }

    @Override
    public List<StoreAvailability> findAll() throws Throwable {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
