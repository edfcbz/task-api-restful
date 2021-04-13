/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.edfcbz.api.bean.StoreCousine;
import br.com.edfcbz.api.idao.IStoreCousineDao;

/**
 *
 * @author Eduardo
 */
public class IStoreCousineDaoImpl extends GenericDao implements IStoreCousineDao {

    //@Override
    public StoreCousine save(StoreCousine param) throws Throwable {
        System.out.println("DAOIMPL StoreCousine");
        return null;//0;//getDbContext().newRecord(STORECOUSINE, param).store();
    }

    //@Override
    public StoreCousine update(StoreCousine param) throws Throwable {
        return null;
    }

    //@Override
    public int delete(StoreCousine param) throws Throwable {
		return 0;/*
					 * getDbContext().delete(STORECOUSINE)
					 * .where(STORECOUSINE.STOREID.eq(param.getStoreId()))
					 * .and(STORECOUSINE.COUSINEID.eq(param.getCousineId())) .execute();
					 */
    }

    //@Override
    public int delete(Integer param) throws Throwable {
        return -1;
    }

    //@Override
    public StoreCousine findById(Integer param) throws Throwable {
        return null;
    }

    //@Override
    public List<StoreCousine> findAll() throws Throwable {
        return null;//getDbContext().select().from(STORECOUSINE).fetch().into(StoreCousine.class);
    }

    //@Override
    public List<StoreCousine> findByName(String param) throws Throwable {
        return new ArrayList<StoreCousine>();//getDbContext().fetch(STORECOUSINE,STORECOUSINE.COUSINEID.eq(param)).into(StoreCousine.class);
    }

}
