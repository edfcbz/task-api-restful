/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.Neighborhood;
import br.com.edfcbz.api.bean.to.NeighborhoodTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.NeighborhoodRecord;
import br.com.edfcbz.api.idao.INeighborhoodDao;

/**
 *
 * @author Eduardo
 */
@Service
public class INeighborhoodDaoImpl extends GenericDao implements INeighborhoodDao {

	
	@Override
	public NeighborhoodTO save(NeighborhoodTO param){		
		try {
			NeighborhoodRecord neighborhoodRecord = getDbContext().newRecord(Tables.NEIGHBORHOOD);
			neighborhoodRecord.setNeighborhood(param.getNeighborhood());
			neighborhoodRecord.store();
			return findById(neighborhoodRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}		
	}

	@Override
	public NeighborhoodTO update(NeighborhoodTO param) {
		try {
			getDbContext()
			.update(Tables.NEIGHBORHOOD)
				.set(Tables.NEIGHBORHOOD.NEIGHBORHOOD_, param.getNeighborhood())
			.where(Tables.NEIGHBORHOOD.ID.eq(param.getId()))
			.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}	
		
	}

	@Override
	public int delete(NeighborhoodTO param){
		return delete(param.getId());
	}

	@Override
	public int delete(Integer param){
		try {
			return  getDbContext().fetchOne(Tables.NEIGHBORHOOD, Tables.NEIGHBORHOOD.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}			
	}

	@Override
	public NeighborhoodTO findById(Integer param) {
		try {
			Neighborhood neighborhood = getDbContext().fetch(Tables.NEIGHBORHOOD, Tables.NEIGHBORHOOD.ID.eq(param)).into(Neighborhood.class).get(0);
			return assemblyTO(neighborhood);
		} catch (Throwable e) { 
			throw new OperationException("Find by id operation not realized");
		}
	}

	@Override
	public List<NeighborhoodTO> findByName(String param){
		try {
			List<Neighborhood> neighborhoodList = getDbContext().fetch(Tables.NEIGHBORHOOD, Tables.NEIGHBORHOOD.NEIGHBORHOOD_.eq(param)).into(Neighborhood.class);
			return assemblyListTO(neighborhoodList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}		
	}
	
	@Override
	public List<NeighborhoodTO> findAll(){
		try {	
			List<Neighborhood> neighborhoodList = getDbContext().select().from(Tables.NEIGHBORHOOD).fetch().into(Neighborhood.class);
			return assemblyListTO(neighborhoodList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<NeighborhoodTO> assemblyListTO(List<Neighborhood> neighborhoodList) {
			List<NeighborhoodTO> neighborhoodListTO = new ArrayList<NeighborhoodTO>();
			neighborhoodList.forEach( neighborhood-> neighborhoodListTO.add(assemblyTO(neighborhood)) );
	return neighborhoodListTO;
	
	}	

	private NeighborhoodTO assemblyTO(Neighborhood neighborhood) {
		NeighborhoodTO neighborhoodTO = new NeighborhoodTO();
			neighborhoodTO.setNeighborhood(neighborhood.getNeighborhood());
			neighborhoodTO.setId(neighborhood.getId());;
		return neighborhoodTO;
	}	
	

}
