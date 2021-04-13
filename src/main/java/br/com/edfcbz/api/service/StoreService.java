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
import br.com.edfcbz.api.bean.to.StoreTO;
import br.com.edfcbz.api.bean.vo.StoreVO;
import br.com.edfcbz.api.service.business.controller.StoreServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class StoreService implements IService<StoreVO> {

	@Autowired 
	StoreServiceBC service;	
	
    @Override
    public StoreVO save(StoreVO param){
    	StoreTO to = DozerConverter.parseObject(param, StoreTO.class);
        return DozerConverter.parseObject(service.save(to), StoreVO.class);    	
    }

    @Override
    public StoreVO update(StoreVO param){
    	
    	StoreTO to = DozerConverter.parseObject(param, StoreTO.class);
        return DozerConverter.parseObject(service.update(to), StoreVO.class);      	
    }

    @Override
    public int delete(StoreVO param){
        return service.delete(param.getKey());    
    }

    @Override
    public int delete(Integer param) {
        return service.delete(param);
    }

    @Override
    public StoreVO findById(Integer param){
        return DozerConverter.parseObject(service.findById(param), StoreVO.class);          
        
    }

    @Override
    public List<StoreVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), StoreVO.class);
    }

    @Override
    public List<StoreVO> findAll(){
    	List<StoreTO> listaTO = service.findAll();
    	return DozerConverter.parseListObjects(listaTO, StoreVO.class);
    }
    
    
}
