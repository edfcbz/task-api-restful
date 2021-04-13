/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.Address;
import br.com.edfcbz.api.bean.Country;
import br.com.edfcbz.api.bean.Cousine;
import br.com.edfcbz.api.bean.to.AddressTO;
import br.com.edfcbz.api.bean.to.CousineTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.CousineRecord;
import br.com.edfcbz.api.idao.ICousineDao;

/**
 *
 * @author Eduardo
 */
@Service
public class ICousineDaoImpl extends GenericDao implements ICousineDao {

	// @Override
	public CousineTO save(CousineTO param) {
		try {
			CousineRecord cousineRecord = getDbContext().newRecord(Tables.COUSINE);
			cousineRecord.setName(param.getName());
			cousineRecord.store();
			return findById(cousineRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}
	}

	// @Override
	public CousineTO update(CousineTO param) {
		try {
			getDbContext().update(Tables.COUSINE)
				.set(Tables.COUSINE.NAME, param.getName())
				.where(Tables.COUSINE.ID.eq(param.getId()))
					.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}

	}

	// @Override
	public int delete(CousineTO param) {
		return delete(param.getId());
	}

	// @Override
	public int delete(Integer param) {
		try {
			return getDbContext().fetchOne(Tables.COUSINE, Tables.COUSINE.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}
	}

	// @Override
	public CousineTO findById(Integer param) {
		try {
			Cousine cousine = getDbContext().fetch(Tables.COUSINE, Tables.COUSINE.ID.eq(param)).into(Cousine.class).get(0);
			return assemblyTO(cousine);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	// @Override
	public List<CousineTO> findByName(String param) {
		try {
			List<Cousine> cousineList = getDbContext().fetch(Tables.COUSINE, Tables.COUSINE.NAME.eq(param)).into(Cousine.class);
			return assemblyListTO(cousineList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}

	// @Override
	public List<CousineTO> findAll() {
		try {
			List<Cousine> cousneList =  getDbContext().select().from(Tables.COUSINE).fetch().into(Cousine.class);
			return assemblyListTO(cousneList);			
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<CousineTO> assemblyListTO(List<Cousine> cousineList) {
			List<CousineTO> cousineListTO = new ArrayList<CousineTO>();
			cousineList.forEach( cousine-> cousineListTO.add(assemblyTO(cousine)) );
	return cousineListTO;

	}	

	private CousineTO assemblyTO(Cousine cousine) {
		CousineTO cousineTO = new CousineTO();
			cousineTO.setId(cousine.getId());
			cousineTO.setName(cousine.getName());
		return cousineTO;
	}	

}
