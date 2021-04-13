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

import br.com.edfcbz.api.bean.Store;
import br.com.edfcbz.api.bean.to.StoreTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.StoreRecord;
import br.com.edfcbz.api.idao.IStoreDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IStoreDaoImpl extends GenericDao implements IStoreDao {

	@Autowired
	IAddressDaoImpl addressDAO;
	
	@Override
	public StoreTO save(StoreTO param){		
		try {
			StoreRecord storeRecord = getDbContext().newRecord(Tables.STORE);
			storeRecord.setDeliveryfee(param.getDeliveryfee());
			storeRecord.setDeliveryfeefreeover(param.getDeliveryfeefreeover());
			storeRecord.setLogo(param.getLogo().getBytes());
			storeRecord.setName(param.getName());
			storeRecord.store();
			
			return findById(storeRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}		
	}

	@Override
	public StoreTO update(StoreTO param) {
		try {
			getDbContext()
			.update(Tables.STORE)
				.set(Tables.STORE.DELIVERYFEE,param.getDeliveryfee())
				.set(Tables.STORE.DELIVERYFEEFREEOVER,param.getDeliveryfeefreeover())
				.set(Tables.STORE.LOGO,param.getLogo().getBytes())
				.set(Tables.STORE.NAME,param.getName())
			.where(Tables.STORE.ID.eq(param.getId()))
			.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}	
		
	}

	@Override
	public int delete(StoreTO param){
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
	public StoreTO findById(Integer param) {
		try {
			Store store = getDbContext().fetch(Tables.STORE, Tables.STORE.ID.eq(param)).into(Store.class).get(0);
			return assemblyTO(store);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	@Override
	public List<StoreTO> findByName(String param){
		try {
			List<Store> storeList =  getDbContext().fetch(Tables.STORE, Tables.STORE.NAME.eq(param)).into(Store.class);                                                           
			return assemblyListTO(storeList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}		
	}
	
	@Override
	public List<StoreTO> findAll(){
		try {	
			List<Store> listStore = getDbContext().select().from(Tables.STORE).fetch().into(Store.class);
			return assemblyListTO(listStore);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<StoreTO> assemblyListTO(List<Store> storeList) {
			List<StoreTO> storeListTO = new ArrayList<StoreTO>();
			storeList.forEach( store-> storeListTO.add(assemblyTO(store)) );
	return storeListTO;

	}	

private StoreTO assemblyTO(Store store) {
			StoreTO storeTO = new StoreTO();
			storeTO.setAddress(addressDAO.findById(store.getId()));;
			storeTO.setDeliveryfee(store.getDeliveryfee());
			storeTO.setDeliveryfeefreeover(store.getDeliveryfeefreeover());
			storeTO.setId(store.getId());
			storeTO.setLogo(store.getLogo());
			storeTO.setName(store.getName());
		return storeTO;
	}


}
