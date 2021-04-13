/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.to.ProductStoreTO;
import br.com.edfcbz.api.dao.impl.IProductStoreDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class ProductStoreServiceBC implements IService<ProductStoreTO> {

	@Autowired
	IProductStoreDaoImpl dao;

	@Override
	public ProductStoreTO save(ProductStoreTO param) {
		return dao.save(param);
	}

	@Override
	public ProductStoreTO update(ProductStoreTO param) {
		return dao.update(param);
	}

	@Override
	public int delete(ProductStoreTO param) {
		return dao.delete(param);
	}

	@Override
	public int delete(Integer param) {
		return dao.delete(param);
	}

	@Override
	public ProductStoreTO findById(Integer param) {
		return dao.findById(param);
	}

	@Override
	public List<ProductStoreTO> findAll() {
		return dao.findAll();
	}

	@Override
	public List<ProductStoreTO> findByName(String param) {
		return dao.findByName(param);
	}

}
