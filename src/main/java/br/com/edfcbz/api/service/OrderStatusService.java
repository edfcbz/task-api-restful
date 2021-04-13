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
import br.com.edfcbz.api.bean.to.OrderStatusTO;
import br.com.edfcbz.api.bean.vo.OrderStatusVO;
import br.com.edfcbz.api.service.business.controller.OrderStatusServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class OrderStatusService implements IService<OrderStatusVO> {

	@Autowired 
	OrderStatusServiceBC service;	
	
    @Override
    public OrderStatusVO save(OrderStatusVO param){
    	OrderStatusTO to = DozerConverter.parseObject(param, OrderStatusTO.class);
        return DozerConverter.parseObject(service.save(to), OrderStatusVO.class);    	
    }

    @Override
    public OrderStatusVO update(OrderStatusVO param){
    	
    	OrderStatusTO to = DozerConverter.parseObject(param, OrderStatusTO.class);
        return DozerConverter.parseObject(service.update(to), OrderStatusVO.class);      	
    }

    @Override
    public int delete(OrderStatusVO param){
        return service.delete(param.getKey());    
    }

    @Override
    public int delete(Integer param) {
        return service.delete(param);
    }

    @Override
    public OrderStatusVO findById(Integer param){
    	 OrderStatusVO vo = DozerConverter.parseObject(service.findById(param), OrderStatusVO.class);   
        return vo;
    }

    @Override
    public List<OrderStatusVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), OrderStatusVO.class);
    }
    
    public List<OrderStatusVO> findByOrderId(Integer param){
    	return DozerConverter.parseListObjects(service.findByOrderId(param), OrderStatusVO.class);
    }
    

    @Override
    public List<OrderStatusVO> findAll(){
    	List<OrderStatusTO> listaTO = service.findAll();
    	return DozerConverter.parseListObjects(listaTO, OrderStatusVO.class);
    }
    
    
}
