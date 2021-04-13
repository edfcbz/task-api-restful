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
import br.com.edfcbz.api.bean.to.ProductTO;
import br.com.edfcbz.api.bean.vo.ProductVO;
import br.com.edfcbz.api.service.business.controller.ProductServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class ProductService implements IService<ProductVO> {

	@Autowired
	ProductServiceBC service;
	
    @Override
    public ProductVO save(ProductVO param){
    	ProductTO to = DozerConverter.parseObject(param, ProductTO.class);
        return DozerConverter.parseObject(service.save(to), ProductVO.class);
    }

    @Override
    public ProductVO update(ProductVO param){
    	ProductTO to = DozerConverter.parseObject(param, ProductTO.class);
        return DozerConverter.parseObject( service.update(to), ProductVO.class);
    }

    @Override
    public int delete(ProductVO param){
    	ProductTO to = DozerConverter.parseObject(param, ProductTO.class);
        return service.delete(to);
    }

    @Override
    public int delete(Integer param){
        return service.delete(param);
    }

    @Override
    public ProductVO findById(Integer param){
    	return DozerConverter.parseObject(service.findById(param), ProductVO.class);
    }

    @Override
    public List<ProductVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), ProductVO.class);
    }
    
    public List<ProductVO> findByCountry(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), ProductVO.class);
    }    
    
    public ProductVO findByCountryId(String param){
    	return DozerConverter.parseObject(service.findById(Integer.parseInt(param)), ProductVO.class);
    }      
    
    @Override
    public List<ProductVO> findAll(){
    	return DozerConverter.parseListObjects(service.findAll(), ProductVO.class);
    }

}
