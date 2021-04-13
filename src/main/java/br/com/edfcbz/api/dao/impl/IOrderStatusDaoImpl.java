/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.OrderStatus;
import br.com.edfcbz.api.bean.to.OrderStatusDomainTO;
import br.com.edfcbz.api.bean.to.OrderStatusTO;
import br.com.edfcbz.api.bean.to.OrderTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.OrderHasStatusRecord;
import br.com.edfcbz.api.idao.IOrderStatusDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IOrderStatusDaoImpl extends GenericDao implements IOrderStatusDao {

	@Autowired
	ICityDaoImpl cityDAO;
	
	@Autowired
	INeighborhoodDaoImpl neighborhoodDAO;
	
	@Autowired
	IOrderDaoImpl orderDAO;	
	
	@Autowired
	IOrderStatusDaoImpl orderStatusDAO;	
	
	@Autowired
	IOrderStatusDomainDaoImpl orderStatusDomainDAO;	
	
	@Override
	public OrderStatusTO save(OrderStatusTO param){		
		try {
			OrderHasStatusRecord orderStatusRecord = getDbContext().newRecord(Tables.ORDER_HAS_STATUS);
			orderStatusRecord.setOrderId(param.getOrder().getId());
			orderStatusRecord.setOrderStatusDomainId(param.getOrderStatusDomain().getId());
			orderStatusRecord.setUpdate( new Timestamp(Calendar.getInstance().getTimeInMillis()));
			orderStatusRecord.store();
			return findById(orderStatusRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}		
	}

	@Override
	public OrderStatusTO update(OrderStatusTO param) {
		try {
			getDbContext()
			.update(Tables.ORDER_HAS_STATUS)
				.set(Tables.ORDER_HAS_STATUS.ORDER_ID, param.getOrder().getId())
				.set(Tables.ORDER_HAS_STATUS.ORDER_STATUS_DOMAIN_ID, param.getOrderStatusDomain().getId())
			.where(Tables.ORDER_HAS_STATUS.ID.eq(param.getId()))
			.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}	
		
	}

	@Override
	public int delete(OrderStatusTO param){
		return delete(param.getId());
	}

	@Override
	public int delete(Integer param){
		try {
			return  getDbContext().fetchOne(Tables.ORDER_HAS_STATUS, Tables.ORDER_HAS_STATUS.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}			
	}

	@Override
	public OrderStatusTO findById(Integer param) {
		try {
			OrderStatus orderStatus = getDbContext().fetch(Tables.ORDER_HAS_STATUS, Tables.ORDER_HAS_STATUS.ID.eq(param)).into(OrderStatus.class).get(0);
			return assemblyTO(orderStatus);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	@Override
	public List<OrderStatusTO> findByName(String param){
		try {
			throw new OperationException("Find by name operation not realized");
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}		
	}
	
	
	public List<OrderStatusTO> findByStatus(OrderStatusDomainTO param){
		try {
			List<OrderStatus> orderStatusList = getDbContext().fetch(Tables.ORDER_HAS_STATUS, Tables.ORDER_HAS_STATUS.ORDER_STATUS_DOMAIN_ID.eq(param.getId())).into(OrderStatus.class);
			return assemblyListTO(orderStatusList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}		
	}	
	
	public List<OrderStatusTO> findByOrderId(Integer param){
		try {
			List<OrderStatus> orderStatusList = getDbContext().fetch(Tables.ORDER_HAS_STATUS, Tables.ORDER_HAS_STATUS.ORDER_ID.eq(param)).into(OrderStatus.class);
			return assemblyListTO(orderStatusList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}		
	}	
	
	@Override
	public List<OrderStatusTO> findAll(){
		try {	
			List<OrderStatus> orderStatusList = getDbContext().select().from(Tables.ORDER_HAS_STATUS).fetch().into(OrderStatus.class);
			return assemblyListTO(orderStatusList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<OrderStatusTO> assemblyListTO(List<OrderStatus> orderStatusList) {
			List<OrderStatusTO> orderStatusListTO = new ArrayList<OrderStatusTO>();
			orderStatusList.forEach( orderStatus-> orderStatusListTO.add(assemblyTO(orderStatus)) );
	return orderStatusListTO;
	
	}	

	private OrderStatusTO assemblyTO(OrderStatus orderStatus) {
		OrderStatusTO orderStatusTO = new OrderStatusTO();
			orderStatusTO.setId(orderStatus.getId());
			orderStatusTO.setOrderStatusDomain(orderStatusDomainDAO.findById(orderStatus.getId()));
			orderStatusTO.setOrder(orderDAO.findById(orderStatus.getOrder_id()));
			
			List<OrderStatusDomainTO> orderStatusDomanListTO = new ArrayList<OrderStatusDomainTO>();
			
			try {
				List<OrderStatus> orderStatusList = getDbContext().fetch(Tables.ORDER_HAS_STATUS, Tables.ORDER_HAS_STATUS.ORDER_ID.eq(orderStatus.getOrder_id())).into(OrderStatus.class);
				for (OrderStatus oorder : orderStatusList) {
					OrderStatusDomainTO to = orderStatusDomainDAO.findById(oorder.getOrder_status_domain_id());
					to.setDate(oorder.getUpdate());
					orderStatusDomanListTO.add(to);
				}

			} catch (Throwable e) {
				throw new OperationException("Find by name operation not rea  lized");
			}	
			
			orderStatusTO.setOrderStatusDomainList(orderStatusDomanListTO);
			orderStatusTO.setUpdate(orderStatus.getUpdate());
			
		return orderStatusTO;
	}	
	

}
