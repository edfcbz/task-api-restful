/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.City;
import br.com.edfcbz.api.bean.Province;
import br.com.edfcbz.api.bean.to.CityTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.CityRecord;
import br.com.edfcbz.api.idao.ICityDao;

/**
 *
 * @author Eduardo
 */
@Service
public class ICityDaoImpl extends GenericDao implements ICityDao {

	@Autowired
	IProvinceDaoImpl provinceDAO;
	
	@Override
	public CityTO save(CityTO param){		
		try {
			CityRecord cityRecord = getDbContext().newRecord(Tables.CITY);
			cityRecord.setName(param.getName());
			cityRecord.setProvinceId( param.getProvince().getId());
			cityRecord.store();
			return findById(cityRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}		
	}

	@Override
	public CityTO update(CityTO param) {
		try {
			getDbContext()
			.update(Tables.CITY)
				.set(Tables.CITY.NAME, param.getName())
				.set(Tables.CITY.PROVINCE_ID, param.getProvince().getId())
			.where(Tables.CITY.ID.eq(param.getId()))
			.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}	
		
	}

	@Override
	public int delete(CityTO param){
		return delete(param.getId());
	}

	@Override
	public int delete(Integer param){
		try {
			return  getDbContext().fetchOne(Tables.CITY, Tables.CITY.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}			
	}

	@Override
	public CityTO findById(Integer param) {
		try {
			City city = getDbContext().fetch(Tables.CITY, Tables.CITY.ID.eq(param)).into(City.class).get(0);
			return assemblyTO(city);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	@Override
	public List<CityTO> findByName(String param){
		try {
			List<City> cityList =  getDbContext().fetch(Tables.CITY, Tables.CITY.NAME.eq(param)).into(City.class);
			return assemblyListTO(cityList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}		
	}
	
	@Override
	public List<CityTO> findAll(){
		try {	
			List<City> cityList = getDbContext().select().from(Tables.CITY).fetch().into(City.class);
			return assemblyListTO(cityList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<CityTO> assemblyListTO(List<City> cityList) {
			List<CityTO> cityListTO = new ArrayList<CityTO>();
			cityList.forEach( city-> cityListTO.add(assemblyTO(city)) );
	return cityListTO;
	
	}	

	private CityTO assemblyTO(City city) {
		CityTO cityTO = new CityTO();
			cityTO.setId(city.getId());
			cityTO.setName(city.getName());
			cityTO.setProvince( provinceDAO.findById(city.getProvinceId()) );
		return cityTO;
	}


}
