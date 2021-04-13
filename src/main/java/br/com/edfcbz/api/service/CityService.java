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
import br.com.edfcbz.api.bean.to.CityTO;
import br.com.edfcbz.api.bean.vo.CityVO;
import br.com.edfcbz.api.service.business.controller.CityServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class CityService implements IService<CityVO> {

	@Autowired 
	CityServiceBC service;	
	
    @Override
    public CityVO save(CityVO param){
    	CityTO to = DozerConverter.parseObject(param, CityTO.class);
        return DozerConverter.parseObject(service.save(to), CityVO.class);    	
    }

    @Override
    public CityVO update(CityVO param){
    	
    	CityTO to = DozerConverter.parseObject(param, CityTO.class);
        return DozerConverter.parseObject(service.update(to), CityVO.class);      	
    }

    @Override
    public int delete(CityVO param){
        return service.delete(param.getKey());    
    }

    @Override
    public int delete(Integer param) {
        return service.delete(param);
    }

    @Override
    public CityVO findById(Integer param){
        return DozerConverter.parseObject(service.findById(param), CityVO.class);          
        
    }

    @Override
    public List<CityVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), CityVO.class);
    }

    @Override
    public List<CityVO> findAll(){
    	return DozerConverter.parseListObjects(service.findAll(), CityVO.class);
    }
    
    
}
