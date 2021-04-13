/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service;

import br.com.edfcbz.api.bean.StoreCousine;
import br.com.edfcbz.api.dao.impl.IStoreCousineDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class StoreCousineService implements IService<StoreCousine> {

    @Override
    public StoreCousine save(StoreCousine param) throws Throwable {
        System.out.println("BO StoreCousine");
        return new IStoreCousineDaoImpl().save(param);
    }

    @Override
    public StoreCousine update(StoreCousine param) throws Throwable {
        return new IStoreCousineDaoImpl().update(param);
    }

    @Override
    public int delete(StoreCousine param) throws Throwable {
        return new IStoreCousineDaoImpl().delete(param);
    }

    @Override
    public int delete(Integer param) throws Throwable {
        return -1;
    }

    @Override
    public StoreCousine findById(Integer param) throws Throwable {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StoreCousine> findByName(String param) {
        
        return new ArrayList<>();
    }

    @Override
    public List<StoreCousine> findAll() throws Throwable {
        return new IStoreCousineDaoImpl().findAll();
    }


    
}
