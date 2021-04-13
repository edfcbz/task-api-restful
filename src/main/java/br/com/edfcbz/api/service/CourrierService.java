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
import br.com.edfcbz.api.bean.to.CourrierTO;
import br.com.edfcbz.api.bean.vo.CourrierVO;
import br.com.edfcbz.api.bean.vo.ProductVO;
import br.com.edfcbz.api.service.business.controller.CourrierServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class CourrierService implements IService<CourrierVO> {

	@Autowired
	CourrierServiceBC service;
	
    @Override
    public CourrierVO save(CourrierVO param){
    	CourrierTO to = DozerConverter.parseObject(param, CourrierTO.class);
        return DozerConverter.parseObject(service.save(to), CourrierVO.class);
    }

    @Override
    public CourrierVO update(CourrierVO param){
    	CourrierTO to = DozerConverter.parseObject(param, CourrierTO.class);
        return DozerConverter.parseObject( service.update(to), CourrierVO.class);
    }

    @Override
    public int delete(CourrierVO param){
    	CourrierTO to = DozerConverter.parseObject(param, CourrierTO.class);
        return service.delete(to);
    }

    @Override
    public int delete(Integer param){
        return service.delete(param);
    }

    @Override
    public CourrierVO findById(Integer param){
    	return DozerConverter.parseObject(service.findById(param), CourrierVO.class);
    }

    @Override
    public List<CourrierVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), CourrierVO.class);
    }
    
    public List<CourrierVO> findByCountry(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), CourrierVO.class);
    }    
    
    public CourrierVO findByCountryId(String param){
    	return DozerConverter.parseObject(service.findById(Integer.parseInt(param)), CourrierVO.class);
    }      
    
    @Override
    public List<CourrierVO> findAll(){
    	return DozerConverter.parseListObjects(service.findAll(), CourrierVO.class);
    }

}
