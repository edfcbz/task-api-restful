/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.TypeAddressTO;
import br.com.edfcbz.api.bean.to.TypeAddress;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.TypeAddressRecord;
import br.com.edfcbz.api.idao.ITypeAddressDao;

/**
 *
 * @author Eduardo
 */
@Service
public class ITypeAddressDaoImpl extends GenericDao implements ITypeAddressDao {

	
	// @Override
	public TypeAddressTO save(TypeAddressTO param) {
		try {
			TypeAddressRecord typeAddressRecord = getDbContext().newRecord(Tables.TYPE_ADDRESS);
			typeAddressRecord.setDescriptionType(param.getDescription_type());
			typeAddressRecord.store();
			return findById(typeAddressRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}
	}

	// @Override
	public TypeAddressTO update(TypeAddressTO param) {
		try {
			getDbContext().update(Tables.TYPE_ADDRESS)
				.set(Tables.TYPE_ADDRESS.DESCRIPTION_TYPE, param.getDescription_type())
				.where(Tables.CUSTOMER.ID.eq(param.getId()))
					.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}

	}

	// @Override
	public int delete(TypeAddressTO param) {
		return delete(param.getId());
	}

	// @Override
	public int delete(Integer param) {
		try {
			return getDbContext().fetchOne(Tables.TYPE_ADDRESS, Tables.TYPE_ADDRESS.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}
	}

	// @Override
	public TypeAddressTO findById(Integer param) {
		try {
			TypeAddress typeAddress = getDbContext().fetch(Tables.TYPE_ADDRESS, Tables.TYPE_ADDRESS.ID.eq(param)).into(TypeAddress.class).get(0);
			return assemblyTO(typeAddress);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	// @Override
	public List<TypeAddressTO> findByName(String param) {
		try {
			List<TypeAddress> typeAddressList = getDbContext().fetch(Tables.TYPE_ADDRESS, Tables.TYPE_ADDRESS.DESCRIPTION_TYPE.eq(param)).into(TypeAddress.class);
			return assemblyListTO(typeAddressList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}

	// @Override
	public List<TypeAddressTO> findAll() {
		try {
			List<TypeAddress> typeAddressList =  getDbContext().select().from(Tables.TYPE_ADDRESS).fetch().into(TypeAddress.class);
			return assemblyListTO(typeAddressList);			
		} catch (Throwable e) {
			//throw new OperationException("Find by id operation not realized");
			throw new OperationException("Buxu");
		}
	}
	
	private List<TypeAddressTO> assemblyListTO(List<TypeAddress> typeAddressList) {
			List<TypeAddressTO> typeAddressListTO = new ArrayList<TypeAddressTO>();
			typeAddressList.forEach( type -> typeAddressListTO.add(assemblyTO(type)) );
	return typeAddressListTO;

	}	

	private TypeAddressTO assemblyTO(TypeAddress typeAddress) {
		TypeAddressTO typeAddressTO = new TypeAddressTO();
			typeAddressTO.setId(typeAddress.getId());
			typeAddressTO.setDescription_type(typeAddress.getDescription_type());
		return typeAddressTO;
	}	

}
