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
import br.com.edfcbz.api.bean.to.ProductTO;
import br.com.edfcbz.api.dao.impl.IProductDaoImpl;
import br.com.edfcbz.api.dao.impl.IProductStoreDaoImpl;
import br.com.edfcbz.api.dao.impl.IStoreDaoImpl;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class ProductServiceBC implements IService<ProductTO> {

	@Autowired
	IProductDaoImpl productDAO;
	
	@Autowired
	IProductStoreDaoImpl productStoreDAO;
	
	@Autowired
	IStoreDaoImpl storeDAO;
	
	@Override
	public ProductTO save(ProductTO param) {

		List<ProductTO> producListTO = findByName(param.getName());
		
		if ( producListTO.size() == 0) {
			ProductTO productTO = productDAO.save(param);
			productTO.setStore(param.getStore());
			saveProductStore( productTO );
			return productTO;
		}else {
			ProductTO productTO = producListTO.get(0);
			productTO.setStore(param.getStore());
			saveProductStore( productTO );
			return productDAO.findById(productTO.getId());
		}
	}
	
	private void saveProductStore( ProductTO productTO ) {
		 if(  !productStoreDAO.productStoreExiste(productTO) ) {
				ProductStoreTO to = new ProductStoreTO();
				to.setProduct(productTO);
				to.setStore(productTO.getStore());
				to = productStoreDAO.save(to);
		 }else {
			 throw new OperationException("Update operation not realized");
		 }

	}
	
	
	
	@Override
	public ProductTO update(ProductTO param) {
		 if( ! productDAO.findById(param.getId()).equals(null) ) {
			 return productDAO.update(param);
		 }else {
			 throw new OperationException("Update operation not realized");
		 }
		
	}

	@Override
	public int delete(ProductTO param){
		return productDAO.delete(param);
	}

	@Override
	public int delete(Integer param)  {
		return productDAO.delete(param);
	}

	@Override
	public ProductTO findById(Integer param) {
		return productDAO.findById(param);
	}

	@Override
	public List<ProductTO> findAll() {
		return productDAO.findAll();
	}

	@Override
	public List<ProductTO> findByName(String param)  {
		return productDAO.findByName(param);
	}


}
