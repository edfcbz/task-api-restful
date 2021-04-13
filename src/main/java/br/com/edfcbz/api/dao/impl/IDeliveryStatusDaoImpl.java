/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.edfcbz.api.bean.DeliveryStatus;
import br.com.edfcbz.api.idao.IDeliveryStatusDao;

/**
 *
 * @author Eduardo
 */
public class IDeliveryStatusDaoImpl extends GenericDao implements IDeliveryStatusDao {

    //@Override
    public DeliveryStatus save(DeliveryStatus param) throws Throwable {
        return null;//0;//getDbContext().newRecord(DELIVERYSTATUS, param).store();
    }

    //@Override
    public DeliveryStatus update(DeliveryStatus param) throws Throwable {
//        int result = getDbContext().update(DELIVERYSTATUS)
//                .set(DELIVERYSTATUS.STATUSID, param.getStatusId())
//                .set(DELIVERYSTATUS.DELIVERYID, param.getDeliveryId())
//                .set(DELIVERYSTATUS.UPDATETIME, param.getUpdateTime())
//                .where(DELIVERYSTATUS.ID.eq(param.getId()))
//                .execute();
//        return result;
    	return null;
    }  

    //@Override
    public int delete(DeliveryStatus param) throws Throwable {
        System.out.println("delete(DeliveryStatus param) throws Throwable");
        return delete(param.getDeliveryId(),param.getStatusId());
    }
    
    public int delete(Integer deliveryId, Integer statusId) throws Throwable {
        System.out.println("delete(Integer deliveryId, Integer statusId) throws Throwable");
//        return getDbContext().delete(DELIVERYSTATUS)
//                .where(DELIVERYSTATUS.STATUSID.eq(statusId))
//                .and(DELIVERYSTATUS.DELIVERYID.eq(deliveryId))
//                .execute();
        return 0;
    }    

    //@Override
    public int delete(Integer param) throws Throwable {
        return 0;// getDbContext().fetchOne(DELIVERYSTATUS, DELIVERYSTATUS.ID.eq(param)).delete();
    }

    //@Override
    public DeliveryStatus findById(Integer param) throws Throwable {
        return null;//getDbContext().fetch(DELIVERYSTATUS, DELIVERYSTATUS.ID.eq(param)).into(DeliveryStatus.class);
    }

    //@Override
    public List<DeliveryStatus> findAll() throws Throwable {
        return null;//getDbContext().select().from(DELIVERYSTATUS).fetch().into(DeliveryStatus.class);
    }

    //@Override
    public List<DeliveryStatus> findByName(String param) throws Throwable {
        return new ArrayList<DeliveryStatus>();
    }

}
