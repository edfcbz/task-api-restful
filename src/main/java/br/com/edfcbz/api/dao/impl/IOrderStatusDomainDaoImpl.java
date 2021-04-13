/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.OrderStatusDomain;
import br.com.edfcbz.api.bean.to.OrderStatusDomainTO;
import br.com.edfcbz.api.bean.to.OrderTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.OrderStatusDomainRecord;
import br.com.edfcbz.api.idao.IOrderStatusDomainDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IOrderStatusDomainDaoImpl extends GenericDao implements IOrderStatusDomainDao {

	@Autowired
	ICityDaoImpl cityDAO;
	
	@Autowired
	INeighborhoodDaoImpl neighborhoodDAO;
	
	@Override
	public OrderStatusDomainTO save(OrderStatusDomainTO param){		
		try {
			OrderStatusDomainRecord orderStatusDomainRecord = getDbContext().newRecord(Tables.ORDER_STATUS_DOMAIN);
			orderStatusDomainRecord.setName(param.getName());
			orderStatusDomainRecord.store();
			return findById(orderStatusDomainRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}		
	}

	@Override
	public OrderStatusDomainTO update(OrderStatusDomainTO param) {
		try {
			getDbContext()
			.update(Tables.ORDER_STATUS_DOMAIN)
				.set(Tables.ORDER_STATUS_DOMAIN.NAME, param.getName())
			.where(Tables.ORDER_STATUS_DOMAIN.ID.eq(param.getId()))
			.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}	
		
	}

	@Override
	public int delete(OrderStatusDomainTO param){
		return delete(param.getId());
	}

	@Override
	public int delete(Integer param){
		try {
			return  getDbContext().fetchOne(Tables.ORDER_STATUS_DOMAIN, Tables.ORDER_STATUS_DOMAIN.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}			
	}

	@Override
	public OrderStatusDomainTO findById(Integer param) {
		try {
			OrderStatusDomain orderStatusDomain = getDbContext().fetch(Tables.ORDER_STATUS_DOMAIN, Tables.ORDER_STATUS_DOMAIN.ID.eq(param)).into(OrderStatusDomain.class).get(0);
			return assemblyTO(orderStatusDomain);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	@Override
	public List<OrderStatusDomainTO> findByName(String param){
		try {
			List<OrderStatusDomain> list = getDbContext().fetch(Tables.ORDER_STATUS_DOMAIN, Tables.ORDER_STATUS_DOMAIN.NAME.eq(param)).into(OrderStatusDomain.class);
			return assemblyListTO(list);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}		
	}
	
	@Override
	public List<OrderStatusDomainTO> findAll(){
		try {	
			List<OrderStatusDomain> orderStatusDomainList = getDbContext().select().from(Tables.ORDER_STATUS_DOMAIN).fetch().into(OrderStatusDomain.class);
			return assemblyListTO(orderStatusDomainList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<OrderStatusDomainTO> assemblyListTO(List<OrderStatusDomain> orderStatusDomainList) {
			List<OrderStatusDomainTO> orderStatusDomainListTO = new ArrayList<OrderStatusDomainTO>();
			orderStatusDomainList.forEach( orderStatusDomain-> orderStatusDomainListTO.add(assemblyTO(orderStatusDomain)) );
	return orderStatusDomainListTO;
	
	}	

	private OrderStatusDomainTO assemblyTO(OrderStatusDomain orderStatusDomain) {
		OrderStatusDomainTO orderStatusDomainTO = new OrderStatusDomainTO();
			orderStatusDomainTO.setId(orderStatusDomain.getId());
			orderStatusDomainTO.setName(orderStatusDomain.getName());
		return orderStatusDomainTO;
	}	
	

}
