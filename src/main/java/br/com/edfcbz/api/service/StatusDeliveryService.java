/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service;

import br.com.edfcbz.api.bean.StatusDelivery;
import br.com.edfcbz.api.dao.impl.IStatusDeliveryDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class StatusDeliveryService implements IService<StatusDelivery> {

    @Override
    public StatusDelivery save(StatusDelivery param) throws Throwable {
        return new IStatusDeliveryDaoImpl().save(param);
    }

    @Override
    public StatusDelivery update(StatusDelivery param) throws Throwable {
        return new IStatusDeliveryDaoImpl().update(param);
    }

    @Override
    public int delete(StatusDelivery param) throws Throwable {
        return new IStatusDeliveryDaoImpl().delete(param);
    }

    @Override
    public int delete(Integer param) throws Throwable {
        return new IStatusDeliveryDaoImpl().delete(param);
    }

    @Override
    public StatusDelivery findById(Integer param) throws Throwable {
        return new IStatusDeliveryDaoImpl().findById(param);
    }

    @Override
    public List<StatusDelivery> findByName(String param) {
        try {
            return new IStatusDeliveryDaoImpl().findByName(param);
        } catch (Throwable ex) {
            Logger.getLogger(StatusDeliveryService.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    @Override
    public List<StatusDelivery> findAll() throws Throwable {
        return new IStatusDeliveryDaoImpl().findAll();
    }

}
