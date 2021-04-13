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

import br.com.edfcbz.api.bean.CourrierNeighborhood;
import br.com.edfcbz.api.bean.to.CourrierNeighborhoodTO;
import br.com.edfcbz.api.bean.to.CustomerTO;
import br.com.edfcbz.api.bean.to.NeighborhoodTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.CourrierHasNeighborhoodRecord;
import br.com.edfcbz.api.idao.ICourrierNeighborhoodDao;

/**
 *
 * @author Eduardo
 */
@Service
public class ICourrierNeighborhoodDaoImpl extends GenericDao implements ICourrierNeighborhoodDao {

	@Autowired
	ICourrierDaoImpl courrierDAO;
	
	@Autowired
	INeighborhoodDaoImpl neighborhoodDAO;
	
	
	@Override
	public CourrierNeighborhoodTO save(CourrierNeighborhoodTO param){		
		try {
			CourrierHasNeighborhoodRecord courrierNeighborhoodRecord = getDbContext().newRecord(Tables.COURRIER_HAS_NEIGHBORHOOD);
			courrierNeighborhoodRecord.setCourrierId(param.getCourrier().getId());
			courrierNeighborhoodRecord.setNeighborhoodId(param.getNeighborhood().getId());
			courrierNeighborhoodRecord.store();
			return findById(courrierNeighborhoodRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}		
	}

	@Override
	public CourrierNeighborhoodTO update(CourrierNeighborhoodTO param) {
		try {
			getDbContext()
			.update(Tables.COURRIER_HAS_NEIGHBORHOOD)
				.set(Tables.COURRIER_HAS_NEIGHBORHOOD.COURRIER_ID, param.getCourrier().getId())
				.set(Tables.COURRIER_HAS_NEIGHBORHOOD.NEIGHBORHOOD_ID, param.getNeighborhood().getId())
			.where(Tables.COURRIER_HAS_NEIGHBORHOOD.ID.eq(param.getId()))
			.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}	
		
	}

	@Override
	public int delete(CourrierNeighborhoodTO param){
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
	public CourrierNeighborhoodTO findById(Integer param) {
		try {
			CourrierNeighborhood courrierNeighborhood = getDbContext().fetch(Tables.COURRIER_HAS_NEIGHBORHOOD, Tables.COURRIER_HAS_NEIGHBORHOOD.ID.eq(param)).into(CourrierNeighborhood.class).get(0);
			return assemblyTO(courrierNeighborhood);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	public List<CourrierNeighborhoodTO> findCourrierByCustomerNeighborhood(NeighborhoodTO neighborhood) {
		try {
			List<CourrierNeighborhood> courrierNeighborhoodList = getDbContext().fetch(Tables.COURRIER_HAS_NEIGHBORHOOD, Tables.COURRIER_HAS_NEIGHBORHOOD.NEIGHBORHOOD_ID.eq(neighborhood.getId())).into(CourrierNeighborhood.class);
			return assemblyListTO(courrierNeighborhoodList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	public List<CourrierNeighborhoodTO> findByNeighborhood(NeighborhoodTO neighborhood) {
		try {
			List<CourrierNeighborhood> courrierNeighborhoodList = getDbContext().fetch(Tables.COURRIER_HAS_NEIGHBORHOOD, Tables.COURRIER_HAS_NEIGHBORHOOD.NEIGHBORHOOD_ID.eq(neighborhood.getId())).into(CourrierNeighborhood.class);
			return assemblyListTO(courrierNeighborhoodList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}		

	@Override
	public List<CourrierNeighborhoodTO> findByName(String param){
		try {
			throw new OperationException("Find by name operation not realized");
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}		
	}
	
	@Override
	public List<CourrierNeighborhoodTO> findAll(){
		try {	
			List<CourrierNeighborhood> courrierNeighborhoodList = getDbContext().select().from(Tables.COURRIER_HAS_NEIGHBORHOOD).fetch().into(CourrierNeighborhood.class);
			return assemblyListTO(courrierNeighborhoodList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<CourrierNeighborhoodTO> assemblyListTO(List<CourrierNeighborhood> courrierNeighborhoodList) {
			List<CourrierNeighborhoodTO> courrierNeighborhoodListTO = new ArrayList<CourrierNeighborhoodTO>();
			courrierNeighborhoodList.forEach( courrierNeighborhood-> courrierNeighborhoodListTO.add(assemblyTO(courrierNeighborhood)) );
	return courrierNeighborhoodListTO;
	
	}	

	private CourrierNeighborhoodTO assemblyTO(CourrierNeighborhood courrierNeighborhood) {
		CourrierNeighborhoodTO courrierNeighborhoodTO = new CourrierNeighborhoodTO();
			courrierNeighborhoodTO.setId(courrierNeighborhood.getId());
			courrierNeighborhoodTO.setCourrier( courrierDAO.findById(courrierNeighborhood.getCourrier_id()) );
			courrierNeighborhoodTO.setNeighborhood( neighborhoodDAO.findById(courrierNeighborhood.getNeighborhood_id()) );
		return courrierNeighborhoodTO;
	}	
	

}
