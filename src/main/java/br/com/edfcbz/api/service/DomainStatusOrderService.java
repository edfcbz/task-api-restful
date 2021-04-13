/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service;

import br.com.edfcbz.api.bean.DomainStatusOrder;
import br.com.edfcbz.api.dao.impl.IDomainStatusOrderDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class DomainStatusOrderService implements IService<DomainStatusOrder>  {

    @Override
    public DomainStatusOrder save(DomainStatusOrder param) throws Throwable {
        return new IDomainStatusOrderDaoImpl().save(param);
    }

    @Override
    public DomainStatusOrder update(DomainStatusOrder param) throws Throwable {
        return new IDomainStatusOrderDaoImpl().update(param);
    }

    @Override
    public int delete(DomainStatusOrder param) throws Throwable {
        System.out.println("BO - Delete classe Country");
        return new IDomainStatusOrderDaoImpl().delete(param);
    }

    @Override
    public int delete(Integer param) throws Throwable {
        return new IDomainStatusOrderDaoImpl().delete(param);
    }

    @Override
    public DomainStatusOrder findById(Integer param) throws Throwable {
        return new IDomainStatusOrderDaoImpl().findById(param);
    }

    @Override
    public List<DomainStatusOrder> findAll() throws Throwable {
        return new IDomainStatusOrderDaoImpl().findAll();
    }

    //Implentação de outros métodos
    @Override
    public List<DomainStatusOrder> findByName(String param){
        try {
            return new IDomainStatusOrderDaoImpl().findByName(param);
        } catch (Throwable ex) {
            Logger.getLogger(DomainStatusOrderService.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    
}
