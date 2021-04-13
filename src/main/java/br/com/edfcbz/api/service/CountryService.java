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
import br.com.edfcbz.api.bean.to.ProvinceTO;
import br.com.edfcbz.api.bean.vo.CountryVO;
import br.com.edfcbz.api.service.business.controller.CountryServiceBC;
import br.com.edfcbz.api.service.interfaces.IService;

/**
 *
 * @author Eduardo
 */
@Service
public class CountryService implements IService<CountryVO> {

	@Autowired
	CountryServiceBC service;
	
    @Override
    public CountryVO save(CountryVO param){
    	CountryTO to = DozerConverter.parseObject(param, CountryTO.class);
        return DozerConverter.parseObject(service.save(to), CountryVO.class);
    }

    @Override
    public CountryVO update(CountryVO param){
    	CountryTO to = DozerConverter.parseObject(param, CountryTO.class);
        return DozerConverter.parseObject( service.update(to), CountryVO.class);
    }

    @Override
    public int delete(CountryVO param){
    	CountryTO to = DozerConverter.parseObject(param, CountryTO.class);
        return service.delete(to);
    }

    @Override
    public int delete(Integer param){
        return service.delete(param);
    }

    @Override
    public CountryVO findById(Integer param){
    	return DozerConverter.parseObject(service.findById(param), CountryVO.class);
    }

    @Override
    public List<CountryVO> findByName(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), CountryVO.class);
    }
    
    public List<CountryVO> findByCountry(String param){
    	return DozerConverter.parseListObjects(service.findByName(param), CountryVO.class);
    }    
    
    public CountryVO findByCountryId(String param){
    	return DozerConverter.parseObject(service.findById(Integer.parseInt(param)), CountryVO.class);
    }      
    
    @Override
    public List<CountryVO> findAll(){
    	return DozerConverter.parseListObjects(service.findAll(), CountryVO.class);
    }

}
