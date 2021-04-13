/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.to.CityTO;
import br.com.edfcbz.api.dao.impl.ICityDaoImpl;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class CityServiceBC implements IService<CityTO> {

	@Autowired
	ICityDaoImpl dao;

	@Override
	public CityTO save(CityTO param) {
		if (!CityExist(param)) {
			return dao.save(param);
		} else {
			throw new OperationException("Country already exist");
		}
	}
	
	private boolean CityExist(CityTO param) {
		return dao.findByName(param.getName())
				.stream()
				.filter(c -> c.getName().equals(param.getName()) && 
						c.getProvince().getId() == param.getProvince().getId())
				.findAny()
				.isPresent();
	}
	
	@Override
	public CityTO update(CityTO param) {
		return dao.update(param);
	}

	@Override
	public int delete(CityTO param) {
		return dao.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return dao.delete(param);
	}

	@Override
	public CityTO findById(Integer param) {
		return dao.findById(param);
	}

	@Override
	public List<CityTO> findAll()  {
		return dao.findAll();
	}

	@Override
	public List<CityTO> findByName(String param) {
		return dao.findByName(param);
	}


}
