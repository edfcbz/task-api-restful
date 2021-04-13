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

import br.com.edfcbz.api.bean.StatusDeliveryDomain;
import br.com.edfcbz.api.bean.to.StatusDeliveryDomainTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.StatusDeliveryDomainRecord;
import br.com.edfcbz.api.idao.IStatusDeliveryDomainDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IStatusDeliveryDomainDaoImpl extends GenericDao implements IStatusDeliveryDomainDao {
	
	// @Override
	public StatusDeliveryDomainTO save(StatusDeliveryDomainTO param) {
		try {
			StatusDeliveryDomainRecord customerRecord = getDbContext().newRecord(Tables.STATUS_DELIVERY_DOMAIN);
			customerRecord.setName(param.getName());
			customerRecord.store();
			return findById(customerRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}
	}

	// @Override
	public StatusDeliveryDomainTO update(StatusDeliveryDomainTO param) {
		try {
			getDbContext().update(Tables.STATUS_DELIVERY_DOMAIN)
				.set(Tables.STATUS_DELIVERY_DOMAIN.NAME, param.getName())
					.where(Tables.STATUS_DELIVERY_DOMAIN.ID.eq(param.getId()))
					.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}

	}

	// @Override
	public int delete(StatusDeliveryDomainTO param) {
		return delete(param.getId());
	}

	// @Override
	public int delete(Integer param) {
		try {
			return getDbContext().fetchOne(Tables.STATUS_DELIVERY_DOMAIN, Tables.STATUS_DELIVERY_DOMAIN.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}
	}

	// @Override
	public StatusDeliveryDomainTO findById(Integer param) {
		try {
			StatusDeliveryDomain domain = getDbContext().fetch(Tables.STATUS_DELIVERY_DOMAIN, Tables.STATUS_DELIVERY_DOMAIN.ID.eq(param)).into(StatusDeliveryDomain.class).get(0);
			return assemblyTO(domain);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	// @Override
	public List<StatusDeliveryDomainTO> findByName(String param) {
		try {
			List<StatusDeliveryDomain> domainList = getDbContext().fetch(Tables.STATUS_DELIVERY_DOMAIN, Tables.STATUS_DELIVERY_DOMAIN.NAME.eq(param)).into(StatusDeliveryDomain.class);
			return assemblyListTO(domainList);
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}

	// @Override
	public List<StatusDeliveryDomainTO> findAll() {
		try {
			List<StatusDeliveryDomain> domainList =  getDbContext().select().from(Tables.STATUS_DELIVERY_DOMAIN).fetch().into(StatusDeliveryDomain.class);
			return assemblyListTO(domainList);			
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");			
		}
	}
	
	private List<StatusDeliveryDomainTO> assemblyListTO(List<StatusDeliveryDomain> domainList) {
			List<StatusDeliveryDomainTO> domainListTO = new ArrayList<StatusDeliveryDomainTO>();
			domainList.forEach( status-> domainListTO.add(assemblyTO(status)) );
	return domainListTO;

	}	

	private StatusDeliveryDomainTO assemblyTO(StatusDeliveryDomain domain) {
		StatusDeliveryDomainTO domainTO = new StatusDeliveryDomainTO();
			domainTO.setId(domain.getId());
			domainTO.setName(domain.getName());
		return domainTO;
	}	

}
