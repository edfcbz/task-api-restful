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
import br.com.edfcbz.api.bean.to.StatusDeliveryDomainTO;
import br.com.edfcbz.api.bean.vo.StatusDeliveryDomainVO;
import br.com.edfcbz.api.service.business.controller.StatusDeliveryDomainServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class StatusDeliveryDomainService implements IService<StatusDeliveryDomainVO> {

	@Autowired
	StatusDeliveryDomainServiceBC service;
	
    @Override
    public StatusDeliveryDomainVO save(StatusDeliveryDomainVO param){
    	StatusDeliveryDomainTO to = DozerConverter.parseObject(param, StatusDeliveryDomainTO.class);
        return DozerConverter.parseObject(service.save(to), StatusDeliveryDomainVO.class);
    }

    @Override
    public StatusDeliveryDomainVO update(StatusDeliveryDomainVO param){
    	StatusDeliveryDomainTO to = DozerConverter.parseObject(param, StatusDeliveryDomainTO.class);
        return DozerConverter.parseObject( service.update(to), StatusDeliveryDomainVO.class);
    }

    @Override
    public int delete(StatusDeliveryDomainVO param){
    	StatusDeliveryDomainTO to = DozerConverter.parseObject(param, StatusDeliveryDomainTO.class);
        return service.delete(to);
    }

    @Override
    public int delete(Integer param){
        return service.delete(param);
    }

    @Override
    public StatusDeliveryDomainVO findById(Integer param){
    	return DozerConverter.parseObject(service.findById(param), StatusDeliveryDomainVO.class);
    }

    @Override
    public List<StatusDeliveryDomainVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), StatusDeliveryDomainVO.class);
    }
    
    public List<StatusDeliveryDomainVO> findByCountry(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), StatusDeliveryDomainVO.class);
    }    
    
    public StatusDeliveryDomainVO findByCountryId(String param){
    	return DozerConverter.parseObject(service.findById(Integer.parseInt(param)), StatusDeliveryDomainVO.class);
    }      
    
    @Override
    public List<StatusDeliveryDomainVO> findAll(){
    	return DozerConverter.parseListObjects(service.findAll(), StatusDeliveryDomainVO.class);
    }

    
}
