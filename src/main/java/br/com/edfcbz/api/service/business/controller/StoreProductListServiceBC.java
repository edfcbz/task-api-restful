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
import br.com.edfcbz.api.bean.to.StoreProductListTO;
import br.com.edfcbz.api.bean.to.StoreTO;
import br.com.edfcbz.api.dao.impl.IProductDaoImpl;
import br.com.edfcbz.api.dao.impl.IStoreDaoImpl;
import br.com.edfcbz.api.dao.impl.IStoreProductListDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class StoreProductListServiceBC implements IService<StoreProductListTO> {

	@Autowired
	IStoreProductListDaoImpl productStoreListDAO;
	
	@Autowired
	IStoreProductListDaoImpl storeProductListDAO;	
	
	@Autowired
	IStoreDaoImpl storeDAO;	
	
	@Autowired
	IProductDaoImpl productDAO;		

	@Override
	public StoreProductListTO save(StoreProductListTO param) {
		return productStoreListDAO.save(param);
	}

	@Override
	public StoreProductListTO update(StoreProductListTO param) {
		return storeProductListDAO.update(param);
	}

	@Override
	public int delete(StoreProductListTO param) {
		try {
			return storeProductListDAO.delete(param);
		} catch (Throwable e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(Integer param) {
		return storeProductListDAO.delete(param);
	}

	@Override
	public StoreProductListTO findById(Integer param) {
//		StoreProductListTO storeProductListTO = new StoreProductListTO();
//		StoreTO storeTO = storeDAO.findById(param);
//		List<ProductTO> sProductListTO = storeProductListDAO.findByStoreId(storeTO.getId());
//		storeProductListTO.setStore(storeTO);
//		storeProductListTO.setProducts(sProductListTO);
		
		return null;// storeProductListTO;
	}
	
	public StoreProductListTO findByStoreId(Integer param) {
		StoreProductListTO storeProductListTO = new StoreProductListTO();
		StoreTO storeTO = storeDAO.findById(param);
		List<ProductTO> sProductListTO = storeProductListDAO.findByStoreId(storeTO.getId());
		storeProductListTO.setStore(storeTO);
		storeProductListTO.setProducts(sProductListTO);
		
		return storeProductListTO;
	}
	
	public StoreProductListTO findByStoreName(String param) {
		
		StoreProductListTO storeProductListTO = new StoreProductListTO();
		StoreTO storeTO = storeDAO.findByName(param).get(0);
		List<ProductTO> sProductListTO = storeProductListDAO.findByStoreId(storeTO.getId());
		storeProductListTO.setStore(storeTO);
		storeProductListTO.setProducts(sProductListTO);
		
		return storeProductListTO;
	}	

	@Override
	public List<StoreProductListTO> findAll() {
		return storeProductListDAO.findAll();
	}

	@Override
	public List<StoreProductListTO> findByName(String param) {
		return storeProductListDAO.findByName(param);
	}

}
