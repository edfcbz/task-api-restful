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
import br.com.edfcbz.api.bean.to.CustomerTO;
import br.com.edfcbz.api.bean.vo.CustomerVO;
import br.com.edfcbz.api.service.business.controller.CustomerServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class CustomerService implements IService<CustomerVO> {

	@Autowired
	CustomerServiceBC service;
	
    @Override
    public CustomerVO save(CustomerVO param){
    	CustomerTO to = DozerConverter.parseObject(param, CustomerTO.class);
        return DozerConverter.parseObject(service.save(to), CustomerVO.class);
    }

    @Override
    public CustomerVO update(CustomerVO param){
    	CustomerTO to = DozerConverter.parseObject(param, CustomerTO.class);
        return DozerConverter.parseObject( service.update(to), CustomerVO.class);
    }

    @Override
    public int delete(CustomerVO param){
    	CustomerTO to = DozerConverter.parseObject(param, CustomerTO.class);
        return service.delete(to);
    }

    @Override
    public int delete(Integer param){
        return service.delete(param);
    }

    @Override
    public CustomerVO findById(Integer param){
    	return DozerConverter.parseObject(service.findById(param), CustomerVO.class);
    }

    @Override
    public List<CustomerVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), CustomerVO.class);
    }
    
    public List<CustomerVO> findByCountry(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), CustomerVO.class);
    }    
    
    public CustomerVO findByCountryId(String param){
    	return DozerConverter.parseObject(service.findById(Integer.parseInt(param)), CustomerVO.class);
    }      
    
    @Override
    public List<CustomerVO> findAll(){
    	return DozerConverter.parseListObjects(service.findAll(), CustomerVO.class);
    }

    
}
