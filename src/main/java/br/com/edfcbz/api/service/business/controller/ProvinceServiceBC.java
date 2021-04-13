/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.Province;
import br.com.edfcbz.api.bean.to.ProvinceTO;
import br.com.edfcbz.api.dao.impl.IProvinceDaoImpl;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class ProvinceServiceBC implements IService<ProvinceTO> {

	@Autowired
	IProvinceDaoImpl daoProvince;

	@Override
	public ProvinceTO save(ProvinceTO param) {
		if (!ProvinceExist(param)) {
			return daoProvince.save(param);
		} else {
			throw new OperationException("Country already exist");
		}
	}
	
	private boolean ProvinceExist(ProvinceTO param) {
		return daoProvince.findByName(param.getName())
				.stream()
				.filter(c -> c.getName().equals(param.getName()) && 
						c.getId().equals(param.getId()))
				.findAny()
				.isPresent();
	}
	
	@Override
	public ProvinceTO update(ProvinceTO param) {
		return daoProvince.update(param);
	}

	@Override
	public int delete(ProvinceTO param){
		return daoProvince.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return daoProvince.delete(param);
	}

	@Override
	public ProvinceTO findById(Integer param) {
		return daoProvince.findById(param);
	}

	@Override
	public List<ProvinceTO> findAll() {
		return daoProvince.findAll();
	}

	@Override
	public List<ProvinceTO> findByName(String param)  {
		return daoProvince.findByName(param);
	}

}
