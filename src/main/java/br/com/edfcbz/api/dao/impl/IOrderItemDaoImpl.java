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

import br.com.edfcbz.api.bean.OrderItem;
import br.com.edfcbz.api.bean.to.OrderItemTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.OrderHasProductRecord;
import br.com.edfcbz.api.idao.IOrderItemDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IOrderItemDaoImpl extends GenericDao implements IOrderItemDao {

	@Autowired
	IProductDaoImpl productDAO;
	
	@Autowired
	IOrderDaoImpl orderDAO;	
	
	@Autowired
	IOrderItemDaoImpl orderItemDAO;	
	
	
	public void saveList(List<OrderItemTO> param) {
		for (OrderItemTO orderItemTO : param) {
			save(orderItemTO);
		}
	}
	
	
	@Override
	public OrderItemTO save(OrderItemTO param){		
		try {
			OrderHasProductRecord orderHasProductRecord = getDbContext().newRecord(Tables.ORDER_HAS_PRODUCT);
			orderHasProductRecord.setOrderId(param.getOrder().getId()); ;
			orderHasProductRecord.setQuantity(param.getId());
			orderHasProductRecord.setProductId( param.getProduct().getId() );
			orderHasProductRecord.store();
			return findById(orderHasProductRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}		
	}

	@Override
	public OrderItemTO update(OrderItemTO param) {
		try {
			getDbContext()
			.update(Tables.ORDER_HAS_PRODUCT)
				.set(Tables.ORDER_HAS_PRODUCT.ORDER_ID, param.getOrder().getId())
				.set(Tables.ORDER_HAS_PRODUCT.PRODUCT_ID, param.getProduct().getId())
				.set(Tables.ORDER_HAS_PRODUCT.QUANTITY, param.getQuantity())
			.where(Tables.ORDER_HAS_PRODUCT.ID.eq(param.getId()))
			.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}	
		
	}

	@Override
	public int delete(OrderItemTO param){
		return delete(param.getId());
	}

	@Override
	public int delete(Integer param){
		try {
			return  getDbContext().fetchOne(Tables.ORDER_HAS_PRODUCT, Tables.ORDER_HAS_PRODUCT.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}			
	}

	@Override
	public OrderItemTO findById(Integer param) {
		try {
			OrderItem orderItem = getDbContext().fetch(Tables.ORDER_HAS_PRODUCT, Tables.ORDER_HAS_PRODUCT.ID.eq(param)).into(OrderItem.class).get(0);
			return assemblyTO(orderItem);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	@Override
	public List<OrderItemTO> findAll(){
		try {	
			List<OrderItem> orderItemList = getDbContext().select().from(Tables.ORDER_HAS_PRODUCT).fetch().into(OrderItem.class);
			return assemblyListTO(orderItemList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<OrderItemTO> assemblyListTO(List<OrderItem> orderItemList) {
			List<OrderItemTO> orderItemListTO = new ArrayList<OrderItemTO>();
			orderItemList.forEach(order-> orderItemListTO.add( assemblyTO(order) ));
	return orderItemListTO;
	
	}		

	private OrderItemTO assemblyTO(OrderItem orderItem) {
		OrderItemTO orderItemTO = new OrderItemTO();
			orderItemTO.setId(orderItem.getId());
			//orderItemTO.setOrder(orderDAO.findById(orderItem.getOrder_id()));
			orderItemTO.setOrder_id(orderItem.getOrder_id());
			orderItemTO.setProduct(productDAO.findById(orderItem.getProduct_id()));
			orderItemTO.setQuantity(orderItem.getQuantity());
		return orderItemTO;
	}

	public List<OrderItemTO> findByOrder(Integer param) throws Throwable {
		List<OrderItem> orderItemList = getDbContext().fetch(Tables.ORDER_HAS_PRODUCT, Tables.ORDER_HAS_PRODUCT.ORDER_ID.eq(param)).into(OrderItem.class);
		return assemblyListTO(orderItemList);
	}	
	
	@Override
	public List<OrderItemTO> findByName(String param) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
