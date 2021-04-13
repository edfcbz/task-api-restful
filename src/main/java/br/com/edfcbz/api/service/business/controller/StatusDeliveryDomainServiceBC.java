/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.to.CustomerTO;
import br.com.edfcbz.api.bean.to.StatusDeliveryDomainTO;
import br.com.edfcbz.api.dao.impl.IStatusDeliveryDomainDaoImpl;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class StatusDeliveryDomainServiceBC implements IService<StatusDeliveryDomainTO> {

	@Autowired
	IStatusDeliveryDomainDaoImpl dao;

	@Override
	public StatusDeliveryDomainTO save(StatusDeliveryDomainTO param) {
		if (!customerExist(param)) {
			return dao.save(param);
		} else {
			throw new OperationException("Status Delivery Domain already exist");
		}
	}
	
	private boolean customerExist(StatusDeliveryDomainTO param) {
		return dao.findByName(param.getName())
				.stream()
				.filter(c -> c.getName().equals(param.getName())) 
				.findAny()
				.isPresent();
	}
	
	@Override
	public StatusDeliveryDomainTO update(StatusDeliveryDomainTO param) {
		if (!customerExist(param)) {
			return dao.update(param);
		} else {
			throw new OperationException("Status Delivery Domain already exist");
		}
	}

	@Override
	public int delete(StatusDeliveryDomainTO param){
		return dao.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return dao.delete(param);
	}

	@Override
	public StatusDeliveryDomainTO findById(Integer param) {
		return dao.findById(param);
	}

	@Override
	public List<StatusDeliveryDomainTO> findAll() {
		return dao.findAll();
	}

	@Override
	public List<StatusDeliveryDomainTO> findByName(String param)  {
		return dao.findByName(param);
	}


}
