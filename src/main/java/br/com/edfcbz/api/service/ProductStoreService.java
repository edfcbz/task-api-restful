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
import br.com.edfcbz.api.bean.to.ProductStoreTO;
import br.com.edfcbz.api.bean.vo.ProductStoreVO;
import br.com.edfcbz.api.service.business.controller.ProductStoreServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class ProductStoreService implements IService<ProductStoreVO> {

	@Autowired
	ProductStoreServiceBC service;
	
    @Override
    public ProductStoreVO save(ProductStoreVO param){
    	ProductStoreTO to = DozerConverter.parseObject(param, ProductStoreTO.class);
        return DozerConverter.parseObject(service.save(to), ProductStoreVO.class);
    }

    @Override
    public ProductStoreVO update(ProductStoreVO param){
    	ProductStoreTO to = DozerConverter.parseObject(param, ProductStoreTO.class);
        return DozerConverter.parseObject( service.update(to), ProductStoreVO.class);
    }

    @Override
    public int delete(ProductStoreVO param){
    	ProductStoreTO to = DozerConverter.parseObject(param, ProductStoreTO.class);
        return service.delete(to);
    }

    @Override
    public int delete(Integer param){
        return service.delete(param);
    }

    @Override
    public ProductStoreVO findById(Integer param){
    	return DozerConverter.parseObject(service.findById(param), ProductStoreVO.class);
    }

    @Override
    public List<ProductStoreVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), ProductStoreVO.class);
    }
    
    public List<ProductStoreVO> findByCountry(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), ProductStoreVO.class);
    }    
    
    public ProductStoreVO findByCountryId(String param){
    	return DozerConverter.parseObject(service.findById(Integer.parseInt(param)), ProductStoreVO.class);
    }      
    
    @Override
    public List<ProductStoreVO> findAll(){
    	return DozerConverter.parseListObjects(service.findAll(), ProductStoreVO.class);
    }

}
