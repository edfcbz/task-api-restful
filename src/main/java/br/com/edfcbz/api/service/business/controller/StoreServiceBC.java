/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.to.StoreTO;
import br.com.edfcbz.api.dao.impl.IStoreDaoImpl;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class StoreServiceBC implements IService<StoreTO> {

	@Autowired
	IStoreDaoImpl dao;

	@Override
	public StoreTO save(StoreTO param) {
		if (!storeExist(param)) {
			return dao.save(param);
		} else {
			throw new OperationException("Country already exist");
		}
	}
	
	private boolean storeExist(StoreTO param) {
		boolean result = dao.findAll()
				.stream()
				.filter(c -> c.getAddress().getId().equals(param.getAddress().getId()) && 
							 c.getName().equals(param.getName()))
				.findAny()
				.isPresent();
		return result;
	}
	
	@Override
	public StoreTO update(StoreTO param) {
		return dao.update(param);
	}

	@Override
	public int delete(StoreTO param) {
		return dao.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return dao.delete(param);
	}

	@Override
	public StoreTO findById(Integer param) {
		return dao.findById(param);
	}

	@Override
	public List<StoreTO> findAll()  {
		return dao.findAll();
	}

	@Override
	public List<StoreTO> findByName(String param) {
		return dao.findByName(param);
	}


}
