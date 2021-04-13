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

import br.com.edfcbz.api.bean.Courrier;
import br.com.edfcbz.api.bean.to.CourrierTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.CourrierRecord;
import br.com.edfcbz.api.idao.ICourrierDao;

/**
 *
 * @author Eduardo
 */
@Service
public class ICourrierDaoImpl extends GenericDao implements ICourrierDao {

	@Autowired
	IAddressDaoImpl addressDAO;
	
	// @Override
	public CourrierTO save(CourrierTO param) {
		try {
			CourrierRecord courrierRecord = getDbContext().newRecord(Tables.COURRIER);
			courrierRecord.setAddressId(param.getAddress().getId());
			courrierRecord.setName(param.getName());
			courrierRecord.store();
			return findById(courrierRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}
	}

	// @Override
	public CourrierTO update(CourrierTO param) {
		try {
			getDbContext().update(Tables.COURRIER)
				.set(Tables.COURRIER.NAME, param.getName())
				.set(Tables.COURRIER.ADDRESS_ID, param.getAddress().getId())
				.where(Tables.COURRIER.ID.eq(param.getId()))
					.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}

	}

	// @Override
	public int delete(CourrierTO param) {
		return delete(param.getId());
	}

	// @Override
	public int delete(Integer param) {
		try {
			return getDbContext().fetchOne(Tables.COURRIER, Tables.COURRIER.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}
	}

	// @Override
	public CourrierTO findById(Integer param) {
		try {
			Courrier courrier = getDbContext().fetch(Tables.COURRIER, Tables.COURRIER.ID.eq(param)).into(Courrier.class).get(0);
			return assemblyTO(courrier);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	// @Override
	public List<CourrierTO> findByName(String param) {
		try {
			List<Courrier> courrierList = getDbContext().fetch(Tables.COURRIER, Tables.COURRIER.NAME.eq(param)).into(Courrier.class);
			return assemblyListTO(courrierList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}

	// @Override
	public List<CourrierTO> findAll() {
		try {
			List<Courrier> courrierList =  getDbContext().select().from(Tables.COURRIER).fetch().into(Courrier.class);
			return assemblyListTO(courrierList);			
		} catch (Throwable e) {
			//throw new OperationException("Find by id operation not realized");
			throw new OperationException("Buxu");
		}
	}
	
	private List<CourrierTO> assemblyListTO(List<Courrier> courrierList) {
			List<CourrierTO> courrierListTO = new ArrayList<CourrierTO>();
			courrierList.forEach( courrier-> courrierListTO.add(assemblyTO(courrier)) );
	return courrierListTO;

	}	

	private CourrierTO assemblyTO(Courrier courrier) {
		CourrierTO courrierTO = new CourrierTO();
			courrierTO.setId(courrier.getId());
			courrierTO.setName(courrier.getName());
			courrierTO.setAddress( addressDAO.findById(courrier.getAddressId()) );
		return courrierTO;
	}	

}
