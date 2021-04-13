/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.to.CourrierNeighborhoodTO;
import br.com.edfcbz.api.bean.to.CustomerAddressTO;
import br.com.edfcbz.api.bean.to.CustomerTO;
import br.com.edfcbz.api.bean.to.DeliveryTO;
import br.com.edfcbz.api.bean.to.NeighborhoodTO;
import br.com.edfcbz.api.bean.to.OrderStatusDomainTO;
import br.com.edfcbz.api.bean.to.OrderStatusTO;
import br.com.edfcbz.api.bean.to.OrderTO;
import br.com.edfcbz.api.dao.impl.IAddressDaoImpl;
import br.com.edfcbz.api.dao.impl.ICourrierNeighborhoodDaoImpl;
import br.com.edfcbz.api.dao.impl.ICustomerAddressDaoImpl;
import br.com.edfcbz.api.dao.impl.ICustomerDaoImpl;
import br.com.edfcbz.api.dao.impl.IDeliveryDaoImpl;
import br.com.edfcbz.api.dao.impl.INeighborhoodDaoImpl;
import br.com.edfcbz.api.dao.impl.IOrderDaoImpl;
import br.com.edfcbz.api.dao.impl.IOrderStatusDaoImpl;
import br.com.edfcbz.api.dao.impl.IOrderStatusDomainDaoImpl;
import br.com.edfcbz.api.enumeration.OrderStatusEnumDomain;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class OrderServiceBC implements IService<OrderTO> {

	@Autowired
	IOrderDaoImpl orderDAO;
	
	@Autowired
	OrderServiceBC orderServiceBC;
	

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
	
	@Autowired
	IOrderStatusDaoImpl orderStatusDAO;		

	@Autowired
	OrderStatusServiceBC orderStatusServiceBC;
	
	@Autowired
	IOrderStatusDomainDaoImpl orderStatusDomaninDAO;		
	
	@Override
	public OrderTO save(OrderTO param) {
		param.setDelivery(createDelivery(param));
		OrderTO orderTO = orderDAO.save(param);		
		saveOrderStatus(orderTO);		
		return orderTO;
	}
	
	
	private void saveOrderStatus(OrderTO orderTO) {
		OrderStatusDomainTO orderStatusDomainTO = orderStatusDomaninDAO.findByName(OrderStatusEnumDomain.RECEIVED_BY_SYSTEM.getDescricao()).get(0) ; 		
		OrderStatusTO orderStatusTO = new OrderStatusTO();
		orderStatusTO.setOrderStatusDomain(orderStatusDomainTO);
		orderStatusTO.setOrder(orderTO);	
		orderStatusTO.setUpdate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		orderStatusServiceBC.save(orderStatusTO);
	}
	
	
	private DeliveryTO  createDelivery(OrderTO param) {
		CustomerTO customerTO = customerDAO.findById(param.getCustomer().getId());
		
		//ENCONTRAR O ENDEREÇO DE ENTREGA DO CUSTOMER
		CustomerAddressTO customerAddressTO = customerAddressDAO.findByCustomer(customerTO);
		
        //AddressTO addressTO = addressDAO.findById(param.getCustomer().getId());
		NeighborhoodTO neighborhoodTO = customerAddressTO.getAddress().getNeighborhood();
		
		//COM O BAIRRO DO ENDEREÇO DA ENTREGA, BUSCAR EM "COURRIER_NEIGHBORHOOD" OS COURRIERS QUE FAZER ENTREGA NO BAIRRO DE ENTREGA DA ORDER
		List<CourrierNeighborhoodTO> selectedCourrierList = courrierNeighborhoodDAO.findCourrierByCustomerNeighborhood(neighborhoodTO);
		
		//UTILIZAR UM METODO RANDOMICO QUE SIMULE A ESCOLHA DE UM DOS COURRIER SELECIONADOS
		CourrierNeighborhoodTO courrierNeighborhoodTO = selectCourrierAvailable(selectedCourrierList);
		
		//INSERIR UM REGISTRO NA TABELA DELIVERY SETANDO O ID DO COURRIER OBTIDO NO PASSO DE SELEÇÃO E RETORNAR O ID DO REGISTRO CRIADO
		DeliveryTO deliveryTO = new DeliveryTO();
		deliveryTO.setCourrier(courrierNeighborhoodTO.getCourrier());
		deliveryTO = deliveryDAO.save(deliveryTO);
		
		return deliveryTO;
	}
	
	
	
	
	
	private CourrierNeighborhoodTO selectCourrierAvailable(List<CourrierNeighborhoodTO> toList) {
		
		Random random = new Random();		
		return toList.get(random.nextInt(2));
	}

	
	@Override
	public OrderTO update(OrderTO param) {
		return orderDAO.update(param);
	}

	@Override
	public int delete(OrderTO param) {
		return orderDAO.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return orderDAO.delete(param);
	}

	@Override
	public OrderTO findById(Integer param) {
		return orderDAO.findById(param);
	}

	@Override
	public List<OrderTO> findAll()  {
		return orderDAO.findAll();
	}

	@Override
	public List<OrderTO> findByName(String param) {
		return null;//dao.findByName(param);
	}


}
