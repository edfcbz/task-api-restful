/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.Country;
import br.com.edfcbz.api.bean.to.CountryTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.CountryRecord;
import br.com.edfcbz.api.idao.ICountryDao;

/**
 *
 * @author Eduardo
 */
@Service
public class ICountryDaoImpl extends GenericDao implements ICountryDao {

	// @Override
	public CountryTO save(CountryTO param) {
		try {
			CountryRecord countryRecord = getDbContext().newRecord(Tables.COUNTRY);
			countryRecord.setName(param.getName());
			countryRecord.setSigle(param.getSigle());
			countryRecord.store();
			return findById(countryRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}
	}

	// @Override
	public CountryTO update(CountryTO param) {
		try {
			getDbContext().update(Tables.COUNTRY).set(Tables.COUNTRY.NAME, param.getName())
					.set(Tables.COUNTRY.SIGLE, param.getSigle())
					.where(Tables.COUNTRY.ID.eq(param.getId()))
					.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}

	}

	// @Override
	public int delete(CountryTO param) {
		return delete(param.getId());
	}

	// @Override
	public int delete(Integer param) {
		try {
			return getDbContext().fetchOne(Tables.COUNTRY, Tables.COUNTRY.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}
	}

	// @Override
	public CountryTO findById(Integer param) {
		try {
			Country country = getDbContext().fetch(Tables.COUNTRY, Tables.COUNTRY.ID.eq(param)).into(Country.class).get(0);
			return assemblyTO(country);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	// @Override
	public List<CountryTO> findByName(String param) {
		try {
			List<Country> countryList = getDbContext().fetch(Tables.COUNTRY, Tables.COUNTRY.NAME.eq(param)).into(Country.class);
			return assemblyListTO(countryList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}

	// @Override
	public List<CountryTO> findAll() {
		try {
			List<Country> countryList =  getDbContext().select().from(Tables.COUNTRY).fetch().into(Country.class);
			return assemblyListTO(countryList);			
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<CountryTO> assemblyListTO(List<Country> countryList) {
		List<CountryTO> countryListTO = new ArrayList<CountryTO>();
		countryList.forEach( country-> countryListTO.add(assemblyTO(country)) );
	return countryListTO;
}	

	private CountryTO assemblyTO(Country country) {
			CountryTO countryTO = new CountryTO();
			countryTO.setId(country.getId());
			countryTO.setName(country.getName());
			countryTO.setSigle(country.getSigle());
		return countryTO;
	}

}
