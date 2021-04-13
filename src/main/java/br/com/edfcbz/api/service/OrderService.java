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
import br.com.edfcbz.api.bean.to.OrderTO;
import br.com.edfcbz.api.bean.vo.OrderVO;
import br.com.edfcbz.api.service.business.controller.OrderServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class OrderService implements IService<OrderVO> {

	@Autowired 
	OrderServiceBC service;	
	
    @Override
    public OrderVO save(OrderVO param){
    	OrderTO to = DozerConverter.parseObject(param, OrderTO.class);
        return DozerConverter.parseObject(service.save(to), OrderVO.class);    	
    }

    @Override
    public OrderVO update(OrderVO param){
    	
    	OrderTO to = DozerConverter.parseObject(param, OrderTO.class);
        return DozerConverter.parseObject(service.update(to), OrderVO.class);      	
    }

    @Override
    public int delete(OrderVO param){
        return service.delete(param. getKey());    
    }

    @Override
    public int delete(Integer param) {
        return service.delete(param);
    }

    @Override
    public OrderVO findById(Integer param){
        return DozerConverter.parseObject(service.findById(param), OrderVO.class);  
    }

    @Override
    public List<OrderVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), OrderVO.class);
    }

    @Override
    public List<OrderVO> findAll(){
    	List<OrderTO> listaTO = service.findAll();
    	return DozerConverter.parseListObjects(listaTO, OrderVO.class);
    }
    
    
}
