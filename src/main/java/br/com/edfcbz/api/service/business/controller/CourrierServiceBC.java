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
import br.com.edfcbz.api.dao.impl.ICourrierDaoImpl;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class CourrierServiceBC implements IService<CourrierTO> {

	@Autowired
	ICourrierDaoImpl dao;

	@Override
	public CourrierTO save(CourrierTO param) {
		if (!courrierExist(param)) {
			return dao.save(param);
		} else {
			throw new OperationException("Courrier already exist");
		}
	}
	
	private boolean courrierExist(CourrierTO param) {
		return dao.findByName(param.getName())
				.stream()
				.filter(c -> c.getName().equals(param.getName()) && 
							 c.getAddress().getId().equals(param.getAddress().getId()))
				.findAny()
				.isPresent();
	}
	
	@Override
	public CourrierTO update(CourrierTO param) {
		if (!courrierExist(param)) {
			return dao.update(param);
		} else {
			throw new OperationException("Courrier already exist");
		}
	}

	@Override
	public int delete(CourrierTO param){
		return dao.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return dao.delete(param);
	}

	@Override
	public CourrierTO findById(Integer param) {
		return dao.findById(param);
	}

	@Override
	public List<CourrierTO> findAll() {
		return dao.findAll();
	}

	@Override
	public List<CourrierTO> findByName(String param)  {
		return dao.findByName(param);
	}


}
