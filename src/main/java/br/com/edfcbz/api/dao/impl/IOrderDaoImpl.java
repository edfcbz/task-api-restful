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

import br.com.edfcbz.api.bean.Order;
import br.com.edfcbz.api.bean.to.OrderItemTO;
import br.com.edfcbz.api.bean.to.OrderTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.OrderRecord;
import br.com.edfcbz.api.idao.IOrderDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IOrderDaoImpl extends GenericDao implements IOrderDao {

	@Autowired
	ICustomerDaoImpl costumerDAO;

	@Autowired
	IOrderItemDaoImpl orderItemDAO;

	@Autowired
	ICourrierDaoImpl courrierDAO;

	@Autowired
	IOrderDaoImpl orderDAO;	
	
	@Autowired
	IDeliveryDaoImpl deliveryDAO;		
	
	// @Override
	public OrderTO save(OrderTO param) {
		try {
			OrderRecord orderRecord = getDbContext().newRecord(Tables.ORDER);
			orderRecord.setContact(param.getContact());
			orderRecord.setDate(param.getDate());
			orderRecord.setCustomerId(param.getCustomer().getId());
			orderRecord.setDeliveryId(param.getDelivery().getId());
			orderRecord.store();

			for (OrderItemTO orderItemTO : param.getListItem()) {
				orderItemTO.setOrder(orderDAO.findById(orderRecord.getId()));
			}
			
			orderItemDAO.saveList(param.getListItem());
			
			return findById(orderRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}
	}

	// @Override
	public OrderTO update(OrderTO param) {
		try {
			getDbContext().update(Tables.ORDER).set(Tables.ORDER.CONTACT, param.getContact())
					.set(Tables.ORDER.CUSTOMER_ID, param.getCustomer().getId()).set(Tables.ORDER.DATE, param.getDate())
					.where(Tables.ORDER.ID.eq(param.getId())).execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}

	}

	// @Override
	public int delete(OrderTO param) {
		return delete(param.getId());
	}

	// @Override
	public int delete(Integer param) {
		try {
			return getDbContext().fetchOne(Tables.CUSTOMER, Tables.CUSTOMER.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}
	}

	// @Override
	public OrderTO findById(Integer param) {
		try {
			Order order = getDbContext().fetch(Tables.ORDER, Tables.ORDER.ID.eq(param)).into(Order.class).get(0);
			return assemblyTO(order);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	// @Override
	public List<OrderTO> findByName(String param) {
		return null;
	}

	// @Override
	public List<OrderTO> findByCostumerId(Integer param) {
		try {
			List<Order> orderList = getDbContext().fetch(Tables.ORDER, Tables.ORDER.CUSTOMER_ID.eq(param)).into(Order.class);
			return assemblyListTO(orderList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}

	// @Override
	public List<OrderTO> findAll() {
		try {
			List<Order> orderList = getDbContext().select().from(Tables.ORDER).fetch().into(Order.class);
			return assemblyListTO(orderList);
		} catch (Throwable e) {
			throw new OperationException("Invalid operation");
		}
	}

	private List<OrderTO> assemblyListTO(List<Order> orderList) {
		try {
			List<OrderTO> orderListTO = new ArrayList<OrderTO>();
			orderList.forEach(order -> orderListTO.add(assemblyTO(order)));
			return orderListTO;
		} catch (Exception e) {
			throw new OperationException("Invalid operation");
		}

	}

	private OrderTO assemblyTO(Order order) {
		OrderTO orderTO = new OrderTO();
		orderTO.setContact(order.getContact());
		orderTO.setCustomer(costumerDAO.findById(order.getCustomer_id()));
		orderTO.setDelivery(deliveryDAO.findById(order.getDelivery_id()));
		orderTO.setDate(order.getDate());
		orderTO.setId(order.getId());
		orderTO.setListItem(assemblyItemsTO(order));
		return orderTO;
	}

	private List<OrderItemTO> assemblyItemsTO(Order order) {
		try {
			return orderItemDAO.findByOrder(order.getId());
		} catch (Throwable e) {
			throw new OperationException("Invalid operation");
		}
	}

}
