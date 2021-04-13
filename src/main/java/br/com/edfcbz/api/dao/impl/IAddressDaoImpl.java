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

import br.com.edfcbz.api.bean.Address;
import br.com.edfcbz.api.bean.to.AddressTO;
import br.com.edfcbz.api.bean.to.NeighborhoodTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.AddressRecord;
import br.com.edfcbz.api.idao.IAddressDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IAddressDaoImpl extends GenericDao implements IAddressDao {

	@Autowired
	ICityDaoImpl cityDAO;
	
	@Autowired
	INeighborhoodDaoImpl neighborhoodDAO;
	
	@Override
	public AddressTO save(AddressTO param){		
		try {
			AddressRecord addressRecord = getDbContext().newRecord(Tables.ADDRESS);
			addressRecord.setAddress(param.getAddress());
			addressRecord.setCityId(param.getCity().getId());
			addressRecord.setCode(param.getCode());
			
			NeighborhoodTO to = neighborhoodDAO.save(param.getNeighborhood());
			addressRecord.setNeighborhoodId( to.getId() );
			addressRecord.setNumber(param.getNumber());
			addressRecord.setReferencepoint(param.getReferencePoint());
			addressRecord.store();
			return findById(addressRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}		
	}

	@Override
	public AddressTO update(AddressTO param) {
		try {
			getDbContext()
			.update(Tables.ADDRESS)
				.set(Tables.ADDRESS.ADDRESS_, param.getAddress())
				.set(Tables.ADDRESS.CITY_ID,  param.getCity().getId())
				.set(Tables.ADDRESS.CODE,     param.getCode())
				.set(Tables.ADDRESS.NUMBER,   param.getNumber())
				.set(Tables.ADDRESS.NEIGHBORHOOD_ID, neighborhoodDAO.findByName(param.getNeighborhood().getNeighborhood()).get(0).getId())
				.set(Tables.ADDRESS.REFERENCEPOINT,  param.getReferencePoint())
			.where(Tables.ADDRESS.ID.eq(param.getId()))
			.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}	
		
	}

	@Override
	public int delete(AddressTO param){
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
	public AddressTO findById(Integer param) {
		try {
			Address address = getDbContext().fetch(Tables.ADDRESS, Tables.ADDRESS.ID.eq(param)).into(Address.class).get(0);
			return assemblyTO(address);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	@Override
	public List<AddressTO> findByName(String param){
		try {
			List<Address> addressList = getDbContext().fetch(Tables.ADDRESS, Tables.ADDRESS.ADDRESS_.eq(param)).into(Address.class);
			return assemblyListTO(addressList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}		
	}
	
	@Override
	public List<AddressTO> findAll(){
		try {	
			List<Address> addressList = getDbContext().select().from(Tables.ADDRESS).fetch().into(Address.class);
			return assemblyListTO(addressList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<AddressTO> assemblyListTO(List<Address> addressList) {
			List<AddressTO> addressListTO = new ArrayList<AddressTO>();
			addressList.forEach( address-> addressListTO.add(assemblyTO(address)) );
	return addressListTO;
	
	}	

	private AddressTO assemblyTO(Address address) {
		AddressTO addressTO = new AddressTO();
			addressTO.setId(address.getId());
			addressTO.setCode(address.getCode());
			addressTO.setCity( cityDAO.findById(address.getCityId()) );
			addressTO.setNumber(address.getNumber());
			addressTO.setAddress(address.getAddress());
			addressTO.setNeighborhood( neighborhoodDAO.findById(address.getNeighborhood_id()) );
			addressTO.setReferencePoint(address.getReferencePoint());
		return addressTO;
	}	
	

}
