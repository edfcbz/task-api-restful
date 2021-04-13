/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.List;

import br.com.edfcbz.api.bean.DomainStatusOrder;
import br.com.edfcbz.api.idao.IDomainStatusOrderDao;

/**
 *
 * @author Eduardo
 */
public class IDomainStatusOrderDaoImpl extends GenericDao implements IDomainStatusOrderDao {

    //@Override
    public DomainStatusOrder save(DomainStatusOrder param) throws Throwable {
        return null;//0;//getDbContext().newRecord(DOMAINSTATUSORDER, param).store();
    }

    //@Override
    public DomainStatusOrder update(DomainStatusOrder param) throws Throwable {
//        return getDbContext().update(DOMAINSTATUSORDER)
//                .set(DOMAINSTATUSORDER.NAME, param.getName())
//                .where(DOMAINSTATUSORDER.ID.eq(param.getId()))
//                .execute();
    	return null;
    }

    //@Override
    public int delete(DomainStatusOrder param) throws Throwable {
        return delete(param.getId());
    }

    //@Override
    public int delete(Integer param) throws Throwable {
        return 0;// getDbContext().fetchOne(DOMAINSTATUSORDER, DOMAINSTATUSORDER.ID.eq(param)).delete();
    }

    //@Override
    public DomainStatusOrder findById(Integer param) throws Throwable {
        return null;//getDbContext().fetch(DOMAINSTATUSORDER, DOMAINSTATUSORDER.ID.eq(param)).into(DomainStatusOrder.class);
    }

    //@Override
    public List<DomainStatusOrder> findAll() throws Throwable {
        return null;//getDbContext().select().from(DOMAINSTATUSORDER).fetch().into(DomainStatusOrder.class);
    }

    //@Override
    public List<DomainStatusOrder> findByName(String param) throws Throwable {
        return null;//getDbContext().fetch(DOMAINSTATUSORDER, DOMAINSTATUSORDER.NAME.eq(param)).into(DomainStatusOrder.class);
    }

}
