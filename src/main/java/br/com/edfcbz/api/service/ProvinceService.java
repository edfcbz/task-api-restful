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
import br.com.edfcbz.api.bean.to.ProvinceTO;
import br.com.edfcbz.api.bean.vo.ProvinceVO;
import br.com.edfcbz.api.service.business.controller.ProvinceServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class ProvinceService implements IService<ProvinceVO> {

	@Autowired
	ProvinceServiceBC service;
	
    @Override
    public ProvinceVO save(ProvinceVO param){
    	ProvinceTO to = DozerConverter.parseObject(param, ProvinceTO.class);
        return DozerConverter.parseObject(service.save(to), ProvinceVO.class);
    }

    @Override
    public ProvinceVO update(ProvinceVO param){
    	ProvinceTO to = DozerConverter.parseObject(param, ProvinceTO.class);
        return DozerConverter.parseObject( service.update(to), ProvinceVO.class);
    }

    @Override
    public int delete(ProvinceVO param){
    	ProvinceTO to = DozerConverter.parseObject(param, ProvinceTO.class);
        return service.delete(to);
    }

    @Override
    public int delete(Integer param){
        return service.delete(param);
    }

    @Override
    public ProvinceVO findById(Integer param){
    	return DozerConverter.parseObject(service.findById(param), ProvinceVO.class);
    }

    @Override
    public List<ProvinceVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), ProvinceVO.class);
    }
    
  
    
    @Override
    public List<ProvinceVO> findAll() throws Throwable {
    	
    	try {
    		return DozerConverter.parseListObjects(service.findAll(), ProvinceVO.class);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
    	
    }

}
