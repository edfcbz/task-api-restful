/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service;

import br.com.edfcbz.api.bean.Availability;
import br.com.edfcbz.api.dao.impl.IAvailabilityDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class AvailabilityService implements IService<Availability> {

    @Override
    public Availability save(Availability param) throws Throwable {
        return new IAvailabilityDaoImpl().save(param);
    }

    @Override
    public Availability update(Availability param) throws Throwable {
        return new IAvailabilityDaoImpl().update(param);
    }

    @Override
    public int delete(Availability param) throws Throwable {
        return delete(param.getId());
    }

    @Override
    public int delete(Integer param) throws Throwable {
        return new IAvailabilityDaoImpl().delete(param);
    }

    @Override
    public Availability findById(Integer param) throws Throwable {
        return new IAvailabilityDaoImpl().findById(param);
    }

    @Override
    public List<Availability> findByName(String param) throws Throwable {
        return new ArrayList<>();
    }

    @Override
    public List<Availability> findAll() throws Throwable {
        return new IAvailabilityDaoImpl().findAll();
    }


    
}
