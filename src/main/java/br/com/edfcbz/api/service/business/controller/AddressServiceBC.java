/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.to.AddressTO;
import br.com.edfcbz.api.dao.impl.IAddressDaoImpl;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class AddressServiceBC implements IService<AddressTO> {

	@Autowired
	IAddressDaoImpl dao;

	@Override
	public AddressTO save(AddressTO param) {
		if (!addressExist(param)) {
			return dao.save(param);
		} else {
			throw new OperationException("Country already exist");
		}
	}
	
	private boolean addressExist(AddressTO param) {
		return dao.findAll()
				.stream()
				.filter(c -> c.getAddress().equals(param.getAddress()) && 
							 c.getCity().getId().equals(param.getCity().getId()) &&
							 c.getCode().equals(param.getCode()) &&
							 c.getNeighborhood().equals(param.getNeighborhood()) &&
							 c.getNumber().equals(param.getNumber()) &&
							 c.getReferencePoint().equals(param.getReferencePoint()))
				.findAny()
				.isPresent();
	}
	
	
	
	@Override
	public AddressTO update(AddressTO param) {
		return dao.update(param);
	}

	@Override
	public int delete(AddressTO param) {
		return dao.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return dao.delete(param);
	}

	@Override
	public AddressTO findById(Integer param) {
		return dao.findById(param);
	}

	@Override
	public List<AddressTO> findAll()  {
		return dao.findAll();
	}

	@Override
	public List<AddressTO> findByName(String param) {
		return dao.findByName(param);
	}


}
