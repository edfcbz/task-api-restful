/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.to.CourrierTO;
import br.com.edfcbz.api.bean.to.CustomerTO;
import br.com.edfcbz.api.dao.impl.ICustomerDaoImpl;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class CustomerServiceBC implements IService<CustomerTO> {

	@Autowired
	ICustomerDaoImpl dao;

	@Override
	public CustomerTO save(CustomerTO param) {
		if (!customerExist(param)) {
			return dao.save(param);
		} else {
			throw new OperationException("Customer already exist");
		}
	}
	
	private boolean customerExist(CustomerTO param) {
		return dao.findByName(param.getName())
				.stream()
				.filter(c -> c.getCreation().equals(param.getCreation()) &&
							 c.getEmail().equals(param.getEmail()) && 
							 c.getLogin().equals(param.getLogin()) && 
							 c.getName().equals(param.getName()) && 
							 c.getPassword().equals(param.getPassword())) 
				.findAny()
				.isPresent();
	}
	
	@Override
	public CustomerTO update(CustomerTO param) {
		if (!customerExist(param)) {
			return dao.update(param);
		} else {
			throw new OperationException("Customer already exist");
		}
	}

	@Override
	public int delete(CustomerTO param){
		return dao.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return dao.delete(param);
	}

	@Override
	public CustomerTO findById(Integer param) {
		return dao.findById(param);
	}

	@Override
	public List<CustomerTO> findAll() {
		return dao.findAll();
	}

	@Override
	public List<CustomerTO> findByName(String param)  {
		return dao.findByName(param);
	}


}
