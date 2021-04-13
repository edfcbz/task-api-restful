/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.to.ProductStoreListTO;
import br.com.edfcbz.api.bean.to.ProductTO;
import br.com.edfcbz.api.dao.impl.IProductDaoImpl;
import br.com.edfcbz.api.dao.impl.IProductStoreListDaoImpl;
import br.com.edfcbz.api.dao.impl.IStoreDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class ProductStoreListServiceBC implements IService<ProductStoreListTO> {

	@Autowired
	IProductStoreListDaoImpl productStoreListDAO;
	
	@Autowired
	IProductDaoImpl productDAO;	
	
	@Autowired
	IStoreDaoImpl storeDAO;		

	@Override
	public ProductStoreListTO save(ProductStoreListTO param) {
		return productStoreListDAO.save(param);
	}

	@Override
	public ProductStoreListTO update(ProductStoreListTO param) {
		return productStoreListDAO.update(param);
	}

	@Override
	public int delete(ProductStoreListTO param) {
		return productStoreListDAO.delete(param);
	}

	@Override
	public int delete(Integer param) {
		return productStoreListDAO.delete(param);
	}

	@Override
	public ProductStoreListTO findById(Integer param) {
		ProductStoreListTO productStoreListTO = productStoreListDAO.findByProductId(param).get(0);
		return productStoreListTO;
	}
	
	public ProductStoreListTO findByDescription(String param) {
		
		ProductTO to = productDAO.findByDescription(param);
		ProductStoreListTO productStoreListTO = productStoreListDAO.findByProductId(to.getId()).get(0);
		
		return productStoreListTO;
	}	

	@Override
	public List<ProductStoreListTO> findAll() {
		return productStoreListDAO.findAll();
	}

	@Override
	public List<ProductStoreListTO> findByName(String param) {
		return productStoreListDAO.findByName(param);
	}

}
