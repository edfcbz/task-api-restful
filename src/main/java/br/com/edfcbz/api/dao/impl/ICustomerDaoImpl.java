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

import br.com.edfcbz.api.bean.Customer;
import br.com.edfcbz.api.bean.to.CustomerTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.CustomerRecord;
import br.com.edfcbz.api.idao.ICustomerDao;

/**
 *
 * @author Eduardo
 */
@Service
public class ICustomerDaoImpl extends GenericDao implements ICustomerDao {

	@Autowired
	IAddressDaoImpl addressDAO;
	
	// @Override
	public CustomerTO save(CustomerTO param) {
		try {
			CustomerRecord customerRecord = getDbContext().newRecord(Tables.CUSTOMER);
			customerRecord.setCreation(param.getCreation());
			customerRecord.setEmail(param.getEmail());
			customerRecord.setName(param.getName());
			customerRecord.setPassword(param.getPassword());
			customerRecord.setLogin(param.getLogin());;
			customerRecord.store();
			return findById(customerRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}
	}

	// @Override
	public CustomerTO update(CustomerTO param) {
		try {
			getDbContext().update(Tables.CUSTOMER)
				.set(Tables.CUSTOMER.CREATION, param.getCreation())
				.set(Tables.CUSTOMER.EMAIL, param.getEmail())
				.set(Tables.CUSTOMER.NAME, param.getName())
				.set(Tables.CUSTOMER.PASSWORD, param.getPassword())
				.set(Tables.CUSTOMER.LOGIN, param.getLogin())
				.where(Tables.CUSTOMER.ID.eq(param.getId()))
					.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}

	}

	// @Override
	public int delete(CustomerTO param) {
		return delete(param.getId());
	}

	// @Override
	public int delete(Integer param) {
		try {
			return getDbContext().fetchOne(Tables.CUSTOMER, Tables.CUSTOMER.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}
	}

	// @Override
	public CustomerTO findById(Integer param) {
		try {
			Customer customer = getDbContext().fetch(Tables.CUSTOMER, Tables.CUSTOMER.ID.eq(param)).into(Customer.class).get(0);
			return assemblyTO(customer);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	// @Override
	public List<CustomerTO> findByName(String param) {
		try {
			List<Customer> customerList = getDbContext().fetch(Tables.CUSTOMER, Tables.CUSTOMER.NAME.eq(param)).into(Customer.class);
			return assemblyListTO(customerList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}

	// @Override
	public List<CustomerTO> findAll() {
		try {
			List<Customer> customerList =  getDbContext().select().from(Tables.CUSTOMER).fetch().into(Customer.class);
			return assemblyListTO(customerList);			
		} catch (Throwable e) {
			//throw new OperationException("Find by id operation not realized");
			throw new OperationException("Buxu");
		}
	}
	
	private List<CustomerTO> assemblyListTO(List<Customer> customerList) {
			List<CustomerTO> customerListTO = new ArrayList<CustomerTO>();
			customerList.forEach( courrier-> customerListTO.add(assemblyTO(courrier)) );
	return customerListTO;

	}	

	private CustomerTO assemblyTO(Customer customer) {
		CustomerTO customerTO = new CustomerTO();
			customerTO.setCreation(customer.getCreation());
			customerTO.setEmail(customer.getEmail());
			customerTO.setId(customer.getId());
			customerTO.setLogin(customer.getLogin());
			customerTO.setName(customer.getName());
			customerTO.setPassword(customer.getPassword());
		return customerTO;
	}	

}
