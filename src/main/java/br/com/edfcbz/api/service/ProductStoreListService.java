/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.converter.DozerConverter;
import br.com.edfcbz.api.bean.to.ProductStoreListTO;
import br.com.edfcbz.api.bean.vo.ProductStoreListVO;
import br.com.edfcbz.api.service.business.controller.ProductStoreListServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class ProductStoreListService implements IService<ProductStoreListVO> {

	@Autowired
	ProductStoreListServiceBC service;
	
    @Override
    public ProductStoreListVO save(ProductStoreListVO param){
    	ProductStoreListTO to = DozerConverter.parseObject(param, ProductStoreListTO.class);
        return DozerConverter.parseObject(service.save(to), ProductStoreListVO.class);
    }

    @Override
    public ProductStoreListVO update(ProductStoreListVO param){
    	ProductStoreListTO to = DozerConverter.parseObject(param, ProductStoreListTO.class);
        return DozerConverter.parseObject( service.update(to), ProductStoreListVO.class);
    }

    @Override
    public int delete(ProductStoreListVO param){
    	ProductStoreListTO to = DozerConverter.parseObject(param, ProductStoreListTO.class);
        return service.delete(to);
    }

    @Override
    public int delete(Integer param){
        return service.delete(param);
    }

    @Override
    public ProductStoreListVO findById(Integer param){
    	return DozerConverter.parseObject(service.findById(param), ProductStoreListVO.class);
    }
    
	public ProductStoreListVO findByDescription(String param){
    	return DozerConverter.parseObject(service.findByDescription(param), ProductStoreListVO.class);
    }    

    @Override
    public List<ProductStoreListVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), ProductStoreListVO.class);
    }
    
    public List<ProductStoreListVO> findByCountry(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), ProductStoreListVO.class);
    }    
    
    public ProductStoreListVO findByCountryId(String param){
    	return DozerConverter.parseObject(service.findById(Integer.parseInt(param)), ProductStoreListVO.class);
    }      
    
    @Override
    public List<ProductStoreListVO> findAll(){
    	return DozerConverter.parseListObjects(service.findAll(), ProductStoreListVO.class);
    }

}
