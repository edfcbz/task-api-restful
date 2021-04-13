/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service;

import br.com.edfcbz.api.bean.DeliveryStatus;
import br.com.edfcbz.api.dao.impl.IDeliveryStatusDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class DeliveryStatusService implements IService<DeliveryStatus> {
    
    @Override
    public DeliveryStatus save(DeliveryStatus param) throws Throwable {
        return new IDeliveryStatusDaoImpl().save(param);
    }

    @Override
    public DeliveryStatus update(DeliveryStatus param) throws Throwable {
        return new IDeliveryStatusDaoImpl().update(param);
    }

    @Override
    public int delete(DeliveryStatus param) throws Throwable {
        return new IDeliveryStatusDaoImpl().delete(param);
    }

    @Override
    public int delete(Integer param) throws Throwable {
        return new IDeliveryStatusDaoImpl().delete(param);
    }

    
    public int delete(Integer param1, Integer param2){
        try {
            return new IDeliveryStatusDaoImpl().delete(param1,param2);
        } catch (Throwable ex) {
            Logger.getLogger(DeliveryStatusService.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }    
    
    @Override
    public DeliveryStatus findById(Integer param) throws Throwable {
        return new IDeliveryStatusDaoImpl().findById(param);
    }

    @Override
    public List<DeliveryStatus> findAll() throws Throwable {
        return new IDeliveryStatusDaoImpl().findAll();
    }

    //Implentação de outros métodos
    @Override
    public List<DeliveryStatus> findByName(String param) throws Throwable {
        return new IDeliveryStatusDaoImpl().findByName(param);
    }
    
    
}
