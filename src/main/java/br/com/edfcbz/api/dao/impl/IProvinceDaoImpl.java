/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jooq.exception.DataAccessException;
import org.jooq.exception.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.Country;
import br.com.edfcbz.api.bean.Province;
import br.com.edfcbz.api.bean.to.ProvinceTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.ProvinceRecord;
import br.com.edfcbz.api.idao.IProvinceDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IProvinceDaoImpl extends GenericDao implements IProvinceDao {
	
	@Autowired
	ICountryDaoImpl countryDAO;
	
	
	// @Override
	public ProvinceTO save(ProvinceTO param) {
		try {
			ProvinceRecord provinceRecord = getDbContext().newRecord(Tables.PROVINCE);
			provinceRecord.setName(param.getName());
			provinceRecord.setSigle(param.getSigle());
			provinceRecord.setCountryId(param.getCountry().getId());
			provinceRecord.store();
			return findById(provinceRecord.getId());
		} catch (Throwable e) {
			//throw new OperationException("Delete operation not realized");
			e.getStackTrace();
			return null;
		}
	}

	@Override
	public ProvinceTO update(ProvinceTO param){
		try {
			getDbContext().update(Tables.PROVINCE)
					.set(Tables.PROVINCE.NAME, param.getName())
					.set(Tables.PROVINCE.SIGLE, param.getSigle())
					.set(Tables.PROVINCE.COUNTRY_ID, param.getCountry().getId())
				.where(Tables.PROVINCE.ID.eq(param.getId())).execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}
	}

	@Override
	public int delete(ProvinceTO param){
		return delete(param.getId());
	}

	@Override
	public int delete(Integer param){
		try {
			return getDbContext().fetchOne(Tables.PROVINCE, Tables.PROVINCE.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}

	}

	@Override
	public ProvinceTO findById(Integer param){
		try {
			Province province = getDbContext().fetch(Tables.PROVINCE, Tables.PROVINCE.ID.eq(param)).into(Province.class).get(0);
			return assemblyTO(province);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}

	}

	@Override
	public List<ProvinceTO> findAll(){
		try {
			List<Province> provinceList = getDbContext().select().from(Tables.PROVINCE).fetch().into(Province.class);
			return assemblyListTO(provinceList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	@Override
	public List<ProvinceTO> findByName(String param){
		try {
			List<Province> provinceList =  getDbContext().fetch(Tables.PROVINCE, Tables.PROVINCE.NAME.eq(param)).into(Province.class);
			return assemblyListTO(provinceList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}	
	}
	
	private List<ProvinceTO> assemblyListTO(List<Province> provinceList) {
		List<ProvinceTO> provinceListTO = new ArrayList<ProvinceTO>();
		provinceList.forEach( province-> provinceListTO.add(assemblyTO(province)) );
	return provinceListTO;
}	

	private ProvinceTO assemblyTO(Province province) {
		ProvinceTO provinceTO = new ProvinceTO();
			provinceTO.setId(province.getId());
			provinceTO.setName(province.getName());
			provinceTO.setSigle(province.getSigle());
			provinceTO.setCountry(countryDAO.findById(province.getCountry_id()));
		return provinceTO;
	}	
	
	
}
