/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service;

import br.com.edfcbz.api.bean.OrderStore;
import br.com.edfcbz.api.dao.impl.IOrderStoreDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class OrderStoreService implements IService<OrderStore>{

    @Override
    public OrderStore save(OrderStore param) throws Throwable {
        return new IOrderStoreDaoImpl().save(param);
    }

    @Override
    public OrderStore update(OrderStore param) throws Throwable {
        return new IOrderStoreDaoImpl().update(param);
    }

    @Override
    public int delete(OrderStore param) throws Throwable {
        return delete(param.getOrderId(),param.getStoreId());
    }

    @Override
    public int delete(Integer param) throws Throwable {
       return -1;
    }
    

    public int delete(Integer param1,Integer param2) throws Throwable {
        return new IOrderStoreDaoImpl().delete(param1,param2);
    }

    @Override
    public OrderStore findById(Integer param) throws Throwable {
        return null;
    }

    @Override
    public List<OrderStore> findByName(String param) throws Throwable {
        return new ArrayList<>();
    }

    @Override
    public List<OrderStore> findAll() throws Throwable {
        return new IOrderStoreDaoImpl().findAll();
    }

    
}
