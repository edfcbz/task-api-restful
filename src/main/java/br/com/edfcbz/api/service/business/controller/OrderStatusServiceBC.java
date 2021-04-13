/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.to.OrderStatusTO;
import br.com.edfcbz.api.dao.impl.IAddressDaoImpl;
import br.com.edfcbz.api.dao.impl.ICourrierNeighborhoodDaoImpl;
import br.com.edfcbz.api.dao.impl.ICustomerAddressDaoImpl;
import br.com.edfcbz.api.dao.impl.ICustomerDaoImpl;
import br.com.edfcbz.api.dao.impl.IDeliveryDaoImpl;
import br.com.edfcbz.api.dao.impl.INeighborhoodDaoImpl;
import br.com.edfcbz.api.dao.impl.IOrderDaoImpl;
import br.com.edfcbz.api.dao.impl.IOrderStatusDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class OrderStatusServiceBC implements IService<OrderStatusTO> {

	@Autowired
	IOrderStatusDaoImpl orderStatusDAO;
	
	@Autowired
	IOrderDaoImpl orderDAO;
	
	@Autowired
	IDeliveryDaoImpl deliveryDAO;
	
	@Autowired
	ICustomerDaoImpl customerDAO;
	
	@Autowired
	IAddressDaoImpl addressDAO;	
	
	@Autowired
	INeighborhoodDaoImpl neighborhoodDAO;	
	
	@Autowired
	ICourrierNeighborhoodDaoImpl courrierNeighborhoodDAO;
	
	@Autowired
	ICustomerAddressDaoImpl customerAddressDAO;	

	@Override
	public OrderStatusTO save(OrderStatusTO param) {
		return orderStatusDAO.save(param);
	}
	
	@Override
	public OrderStatusTO update(OrderStatusTO param) {
		return orderStatusDAO.update(param);
	}

	@Override
	public int delete(OrderStatusTO param) {
		return orderStatusDAO.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return orderStatusDAO.delete(param);
	}

	@Override
	public OrderStatusTO findById(Integer param) {
		return orderStatusDAO.findById(param);
	}

	@Override
	public List<OrderStatusTO> findAll()  {
		return orderStatusDAO.findAll();
	}

	@Override
	public List<OrderStatusTO> findByName(String param) {
		return orderStatusDAO.findByName(param);
	}

	public List<OrderStatusTO> findByOrderId(Integer param) {
		return orderStatusDAO.findByOrderId(param);
	}	

}
