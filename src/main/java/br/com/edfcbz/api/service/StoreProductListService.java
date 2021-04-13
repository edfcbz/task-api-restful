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
import br.com.edfcbz.api.bean.to.StoreProductListTO;
import br.com.edfcbz.api.bean.vo.StoreProductListVO;
import br.com.edfcbz.api.service.business.controller.StoreProductListServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class StoreProductListService implements IService<StoreProductListVO> {

	@Autowired
	StoreProductListServiceBC service;
	
    @Override
    public StoreProductListVO save(StoreProductListVO param){
    	StoreProductListTO to = DozerConverter.parseObject(param, StoreProductListTO.class);
        return DozerConverter.parseObject(service.save(to), StoreProductListVO.class);
    }

    @Override
    public StoreProductListVO update(StoreProductListVO param){
    	StoreProductListTO to = DozerConverter.parseObject(param, StoreProductListTO.class);
        return DozerConverter.parseObject( service.update(to), StoreProductListVO.class);
    }

    @Override
    public int delete(StoreProductListVO param){
    	StoreProductListTO to = DozerConverter.parseObject(param, StoreProductListTO.class);
        return service.delete(to);
    }

    @Override
    public int delete(Integer param){
        return service.delete(param);
    }

    @Override
    public StoreProductListVO findById(Integer param){
    	return DozerConverter.parseObject(service.findById(param), StoreProductListVO.class);
    }
    
	public StoreProductListVO findByStoreName(String param){
    	return DozerConverter.parseObject(service.findByStoreName(param), StoreProductListVO.class);
    }    

	public StoreProductListVO findByStoreId(int param){
    	return DozerConverter.parseObject(service.findByStoreId(param), StoreProductListVO.class);
    }	
	
    @Override
    public List<StoreProductListVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), StoreProductListVO.class);
    }
    
    public List<StoreProductListVO> findByCountry(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), StoreProductListVO.class);
    }    
    
    public StoreProductListVO findByCountryId(String param){
    	return DozerConverter.parseObject(service.findById(Integer.parseInt(param)), StoreProductListVO.class);
    }      
    
    @Override
    public List<StoreProductListVO> findAll(){
    	return DozerConverter.parseListObjects(service.findAll(), StoreProductListVO.class);
    }

}
