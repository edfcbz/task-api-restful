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
import br.com.edfcbz.api.bean.to.CountryTO;
import br.com.edfcbz.api.bean.to.CousineTO;
import br.com.edfcbz.api.bean.vo.CountryVO;
import br.com.edfcbz.api.bean.vo.CousineVO;
import br.com.edfcbz.api.service.business.controller.CousineServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class CousineService implements IService<CousineVO> {

	@Autowired
	CousineServiceBC service;
	
    @Override
    public CousineVO save(CousineVO param){
    	CousineTO to = DozerConverter.parseObject(param, CousineTO.class);
        return DozerConverter.parseObject(service.save(to), CousineVO.class);
    }

    @Override
    public CousineVO update(CousineVO param){
    	CousineTO to = DozerConverter.parseObject(param, CousineTO.class);
        return DozerConverter.parseObject( service.update(to), CousineVO.class);
    }

    @Override
    public int delete(CousineVO param){
    	CousineTO to = DozerConverter.parseObject(param, CousineTO.class);
        return service.delete(to);
    }

    @Override
    public int delete(Integer param){
        return service.delete(param);
    }

    @Override
    public CousineVO findById(Integer param){
    	return DozerConverter.parseObject(service.findById(param), CousineVO.class);
    }

    @Override
    public List<CousineVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), CousineVO.class);
    }
    
    public List<CousineVO> findByCountry(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), CousineVO.class);
    }    
    
    public CousineVO findByCountryId(String param){
    	return DozerConverter.parseObject(service.findById(Integer.parseInt(param)), CousineVO.class);
    }      
    
    @Override
    public List<CousineVO> findAll(){
    	return DozerConverter.parseListObjects(service.findAll(), CousineVO.class);
    }

}
