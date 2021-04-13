/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.Delivery;
import br.com.edfcbz.api.bean.to.DeliveryTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.DeliveryRecord;
import br.com.edfcbz.api.idao.IDeliveryDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IDeliveryDaoImpl extends GenericDao implements IDeliveryDao {

	@Autowired
	IProvinceDaoImpl provinceDAO;

	@Autowired
	ICourrierDaoImpl courrierDAO;
	
	@Override
	public DeliveryTO save(DeliveryTO param){		
		try {
			DeliveryRecord deliveryRecord = getDbContext().newRecord(Tables.DELIVERY);
			deliveryRecord.setCourrierId(param.getCourrier().getId());
			deliveryRecord.setUpdate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			deliveryRecord.store();
			return findById(deliveryRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation not realized");
		}		
	}

	@Override
	public DeliveryTO update(DeliveryTO param) {
		try {
			getDbContext()
			.update(Tables.DELIVERY)
				.set(Tables.DELIVERY.COURRIER_ID, param.getCourrier().getId())
			.where(Tables.DELIVERY.ID.eq(param.getId()))
			.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}	
		
	}

	@Override
	public int delete(DeliveryTO param){
		return delete(param.getId());
	}

	@Override
	public int delete(Integer param){
		try {
			return  getDbContext().fetchOne(Tables.DELIVERY, Tables.DELIVERY.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}			
	}

	@Override
	public DeliveryTO findById(Integer param) {
		try {
			Delivery delivery = getDbContext().fetch(Tables.DELIVERY, Tables.DELIVERY.ID.eq(param)).into(Delivery.class).get(0);
			return assemblyTO(delivery);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	@Override
	public List<DeliveryTO> findByName(String param){
		try {
			throw new OperationException("Find by name operation not realized");
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}		
	}
	
	@Override
	public List<DeliveryTO> findAll(){
		try {	
			List<Delivery> deliveryList = getDbContext().select().from(Tables.DELIVERY).fetch().into(Delivery.class);
			return assemblyListTO(deliveryList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<DeliveryTO> assemblyListTO(List<Delivery> deliveryList) {
			List<DeliveryTO> deliveryListTO = new ArrayList<DeliveryTO>();
			deliveryList.forEach( delivery-> deliveryListTO.add(assemblyTO(delivery)) );
	return deliveryListTO;
	
	}	

	private DeliveryTO assemblyTO(Delivery delivery) {
		DeliveryTO deliveryTO = new DeliveryTO();
			deliveryTO.setId(delivery.getId());
			deliveryTO.setCourrier(courrierDAO.findById(delivery.getCourrier_id()));;
		return deliveryTO;
	}


}
