/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.Country;
import br.com.edfcbz.api.bean.to.CountryTO;
import br.com.edfcbz.api.dao.impl.ICountryDaoImpl;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class CountryServiceBC implements IService<CountryTO> {

	@Autowired
	ICountryDaoImpl dao;

	@Override
	public CountryTO save(CountryTO param) {
		if (!CountryExist(param)) {
			return dao.save(param);
		} else {
			throw new OperationException("Country already exist");
		}
	}
	
	private boolean CountryExist(CountryTO param) {
		return dao.findByName(param.getName())
				.stream()
				.filter(c -> c.getName().equals(param.getName()) && 
						c.getSigle().equals(param.getSigle()))
				.findAny()
				.isPresent();
	}
	
	@Override
	public CountryTO update(CountryTO param) {
		return dao.update(param);
	}

	@Override
	public int delete(CountryTO param){
		return dao.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return dao.delete(param);
	}

	@Override
	public CountryTO findById(Integer param) {
		return dao.findById(param);
	}

	@Override
	public List<CountryTO> findAll() {
		return dao.findAll();
	}

	@Override
	public List<CountryTO> findByName(String param)  {
		return dao.findByName(param);
	}


}
