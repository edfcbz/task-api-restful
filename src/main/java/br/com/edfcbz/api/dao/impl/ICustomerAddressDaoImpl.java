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

import br.com.edfcbz.api.bean.CustomerAddress;
import br.com.edfcbz.api.bean.TypeAddressTO;
import br.com.edfcbz.api.bean.to.CustomerAddressTO;
import br.com.edfcbz.api.bean.to.CustomerTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.CustomerHasAddressRecord;
import br.com.edfcbz.api.idao.ICustomerAddressDao;

/**
 *
 * @author Eduardo
 */
@Service
public class ICustomerAddressDaoImpl extends GenericDao implements ICustomerAddressDao {

	@Autowired
	IAddressDaoImpl addressDAO;
	
	@Autowired
	ICustomerDaoImpl customerDAO;
	
	@Autowired
	ITypeAddressDaoImpl typeAddressDAO;
	
	// @Override
	public CustomerAddressTO save(CustomerAddressTO param) {
		try {
			CustomerHasAddressRecord customerAddressRecord = getDbContext().newRecord(Tables.CUSTOMER_HAS_ADDRESS);
			customerAddressRecord.setCustomerId(param.getCustomer().getId());
			customerAddressRecord.setAddressId(param.getAddress().getId());
			customerAddressRecord.setTypeAddressId(param.getType().getId());
			customerAddressRecord.store();
			return findById(customerAddressRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}
	}

	// @Override
	public CustomerAddressTO update(CustomerAddressTO param) {
		try {
			getDbContext().update(Tables.CUSTOMER_HAS_ADDRESS)
				.set(Tables.CUSTOMER_HAS_ADDRESS.ADDRESS_ID, param.getAddress().getId())
				.set(Tables.CUSTOMER_HAS_ADDRESS.CUSTOMER_ID, param.getCustomer().getId())
				.set(Tables.CUSTOMER_HAS_ADDRESS.TYPE_ADDRESS_ID, param.getType().getId())
				.where(Tables.CUSTOMER_HAS_ADDRESS.ID.eq(param.getId()))
					.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}

	}

	// @Override
	public int delete(CustomerAddressTO param) {
		return delete(param.getId());
	}

	// @Override
	public int delete(Integer param) {
		try {
			return getDbContext().fetchOne(Tables.CUSTOMER_HAS_ADDRESS, Tables.CUSTOMER_HAS_ADDRESS.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}
	}

	// @Override
	public CustomerAddressTO findById(Integer param) {
		try {
			CustomerAddress customerAddress = getDbContext().fetch(Tables.CUSTOMER_HAS_ADDRESS, Tables.CUSTOMER_HAS_ADDRESS.ID.eq(param)).into(CustomerAddress.class).get(0);
			return assemblyTO(customerAddress);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
		
	public CustomerAddressTO findByType(TypeAddressTO param) {
		try {
			CustomerAddress customerAddress = getDbContext().fetch(Tables.CUSTOMER_HAS_ADDRESS, Tables.CUSTOMER_HAS_ADDRESS.TYPE_ADDRESS_ID.eq(param.getId())).into(CustomerAddress.class).get(0);
			return assemblyTO(customerAddress);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	public CustomerAddressTO findByCustomer(CustomerTO customer) {
		try {
			CustomerAddress customerAddress = getDbContext().fetch(Tables.CUSTOMER_HAS_ADDRESS, Tables.CUSTOMER_HAS_ADDRESS.CUSTOMER_ID.eq(customer.getId())).into(CustomerAddress.class).get(0);
			return assemblyTO(customerAddress);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}	

	// @Override
	public List<CustomerAddressTO> findByName(String param) {
		try {
			throw new OperationException("Find by name operation not realized");
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}

	// @Override
	public List<CustomerAddressTO> findAll() {
		try {
			List<CustomerAddress> customerAddressList =  getDbContext().select().from(Tables.CUSTOMER_HAS_ADDRESS).fetch().into(CustomerAddress.class);
			return assemblyListTO(customerAddressList);			
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<CustomerAddressTO> assemblyListTO(List<CustomerAddress> customerAddressList) {
			List<CustomerAddressTO> customerAddressListTO = new ArrayList<CustomerAddressTO>();
			customerAddressList.forEach( customerAddress-> customerAddressListTO.add(assemblyTO(customerAddress)) );
	return customerAddressListTO;

	}	

	private CustomerAddressTO assemblyTO(CustomerAddress customerAddress) {
		CustomerAddressTO customerAddressTO = new CustomerAddressTO();
			customerAddressTO.setId(customerAddress.getId());
			customerAddressTO.setAddress( addressDAO.findById(customerAddress.getAddress_id()));
			customerAddressTO.setCustomer(customerDAO.findById(customerAddress.getCustomer_id()));
			customerAddressTO.setType(typeAddressDAO.findById(customerAddress.getType_address_id()));
		return customerAddressTO;
	}	

}
