/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.to.CountryTO;
import br.com.edfcbz.api.bean.to.CousineTO;
import br.com.edfcbz.api.dao.impl.ICousineDaoImpl;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class CousineServiceBC implements IService<CousineTO> {

	@Autowired
	ICousineDaoImpl dao;

	@Override
	public CousineTO save(CousineTO param) {
		if (!cousineExist(param)) {
			return dao.save(param);
		} else {
			throw new OperationException("Cousine already exist");
		}
	}
	
	private boolean cousineExist(CousineTO param) {
		return dao.findByName(param.getName())
				.stream()
				.filter(c -> c.getName().equals(param.getName()))
				.findAny()
				.isPresent();
	}
	
	@Override
	public CousineTO update(CousineTO param) {
		if (!cousineExist(param)) {
			return dao.update(param);
		} else {
			throw new OperationException("Cousine already exist");
		}
	}

	@Override
	public int delete(CousineTO param){
		return dao.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return dao.delete(param);
	}

	@Override
	public CousineTO findById(Integer param) {
		return dao.findById(param);
	}

	@Override
	public List<CousineTO> findAll() {
		return dao.findAll();
	}

	@Override
	public List<CousineTO> findByName(String param)  {
		return dao.findByName(param);
	}


}
