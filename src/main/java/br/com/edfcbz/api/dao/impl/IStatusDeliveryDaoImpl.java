/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.edfcbz.api.bean.StatusDelivery;
import br.com.edfcbz.api.idao.IStatusDeliveryDao;

/**
 *
 * @author Eduardo
 */
public class IStatusDeliveryDaoImpl extends GenericDao implements IStatusDeliveryDao {

    //@Override
    public StatusDelivery save(StatusDelivery param) throws Throwable {
        return null;//0;// getDbContext().newRecord(DELIVERYSTATUS, param).store();
    }

    //@Override
    public StatusDelivery update(StatusDelivery param) throws Throwable {
        return null;
    }

    //@Override
    public int delete(StatusDelivery param) throws Throwable {
        return delete(param.getDeliveryId());
    }

    //@Override
    public int delete(Integer param) throws Throwable {
        return 0;//getDbContext().fetchOne(DELIVERYSTATUS, DELIVERYSTATUS.DELIVERYID.eq(param)).delete();
    }

    //@Override
    public StatusDelivery findById(Integer param) throws Throwable {
        return null;//getDbContext().fetch(DELIVERYSTATUS, DELIVERYSTATUS.DELIVERYID.eq(param)).into(StatusDelivery.class);
    }

    //@Override
    public List<StatusDelivery> findByName(String param) throws Throwable {
        return new ArrayList<StatusDelivery>();
    }

    //@Override
    public List<StatusDelivery> findAll() throws Throwable {
        return null;//getDbContext().select().from(DELIVERYSTATUS).fetch().into(StatusDelivery.class);
    }

}
