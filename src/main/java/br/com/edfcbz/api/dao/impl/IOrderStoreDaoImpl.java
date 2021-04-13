/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.edfcbz.api.bean.OrderStore;
import br.com.edfcbz.api.idao.IOrderStoreDao;

/**
 *
 * @author Eduardo
 */
public class IOrderStoreDaoImpl extends GenericDao implements IOrderStoreDao {

    ////@Override
    public OrderStore save(OrderStore param) throws Throwable {
        return null;//0;//getDbContext().newRecord(ORDERSTORE, param).store();
    }

    ////@Override
    public OrderStore update(OrderStore param) throws Throwable {
        return null;
    }

    ////@Override
    public int delete(OrderStore param) throws Throwable {
        return delete(param.getOrderId(), param.getStoreId());
    }

    public int delete(Integer param1, Integer param2) throws Throwable {
        return 0; /*getDbContext().delete(ORDERSTORE)
                .where(ORDERSTORE.ORDERID.eq(param1))
                .and(ORDERSTORE.STOREID.eq(param2))
                .execute();*/
    }

    ////@Override
    public int delete(Integer param) throws Throwable {
        return 0;// getDbContext().fetchOne(COUNTRY, COUNTRY.ID.eq(param)).delete();
    }

    ////@Override
    public OrderStore findById(Integer param) throws Throwable {
        return null;
    }

    ////@Override
    public List<OrderStore> findAll() throws Throwable {
        return null;//getDbContext().select().from(ORDERSTORE).fetch().into(OrderStore.class);
    }

    ////@Override
    public List<OrderStore> findByName(String param) throws Throwable {
        return new ArrayList<OrderStore>();
    }

}
