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
import br.com.edfcbz.api.bean.to.AddressTO;
import br.com.edfcbz.api.bean.to.CityTO;
import br.com.edfcbz.api.bean.vo.AddressVO;
import br.com.edfcbz.api.bean.vo.CityVO;
import br.com.edfcbz.api.service.business.controller.AddressServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class AddressService implements IService<AddressVO> {

	@Autowired 
	AddressServiceBC service;	
	
    @Override
    public AddressVO save(AddressVO param){
    	AddressTO to = DozerConverter.parseObject(param, AddressTO.class);
        return DozerConverter.parseObject(service.save(to), AddressVO.class);    	
    }

    @Override
    public AddressVO update(AddressVO param){
    	
    	AddressTO to = DozerConverter.parseObject(param, AddressTO.class);
        return DozerConverter.parseObject(service.update(to), AddressVO.class);      	
    }

    @Override
    public int delete(AddressVO param){
        return service.delete(param.getKey());    
    }

    @Override
    public int delete(Integer param) {
        return service.delete(param);
    }

    @Override
    public AddressVO findById(Integer param){
        return DozerConverter.parseObject(service.findById(param), AddressVO.class);          
        
    }

    @Override
    public List<AddressVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), AddressVO.class);
    }

    @Override
    public List<AddressVO> findAll(){
    	List<AddressTO> listaTO = service.findAll();
    	return DozerConverter.parseListObjects(listaTO, AddressVO.class);
    }
    
    
}
