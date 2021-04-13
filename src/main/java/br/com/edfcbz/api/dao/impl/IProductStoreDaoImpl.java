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

import br.com.edfcbz.api.bean.ProductStore;
import br.com.edfcbz.api.bean.to.ProductStoreTO;
import br.com.edfcbz.api.bean.to.ProductTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.ProductHasStoreRecord;
import br.com.edfcbz.api.idao.IProductStoreDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IProductStoreDaoImpl extends GenericDao implements IProductStoreDao {

	@Autowired
	IProductDaoImpl productDAO;
	
	@Autowired
	IStoreDaoImpl storeDAO;
	
	
	@Override
	public ProductStoreTO save(ProductStoreTO param) {
		try {
			ProductHasStoreRecord productStoreRecord = getDbContext().newRecord(Tables.PRODUCT_HAS_STORE);
			productStoreRecord.setProductId(param.getProduct().getId());
			productStoreRecord.setStoreId(param.getStore().getId());
			productStoreRecord.store();
			
			return findById(productStoreRecord.getId());
		} catch (Throwable e) {
			throw new OperationException("Insert operation  not realized");
		}
	}

	@Override
	public ProductStoreTO update(ProductStoreTO param) {
		try {
			getDbContext().update(Tables.PRODUCT_HAS_STORE)
				.set(Tables.PRODUCT_HAS_STORE.PRODUCT_ID, param.getId())
				.set(Tables.PRODUCT_HAS_STORE.STORE_ID, param.getStore().getId())
				.where(Tables.PRODUCT_HAS_STORE.ID.eq(param.getId()))
					.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}

	}

	@Override
	public int delete(ProductStoreTO param) {
			try {
				return delete(param.getId());
			} catch (Throwable e) {
				throw new OperationException("Delete operation not realized");
			}
	}

	@Override
	public int delete(Integer param) {
		try {
			return getDbContext().fetchOne(Tables.PRODUCT_HAS_STORE, Tables.PRODUCT_HAS_STORE.PRODUCT_ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}
	}

	@Override
	public ProductStoreTO findById(Integer param) {
		try {
			ProductStore productStore = getDbContext().fetch(Tables.PRODUCT_HAS_STORE, Tables.PRODUCT_HAS_STORE.ID.eq(param)).into(ProductStore.class).get(0);
			return assemblyTO(productStore);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	@Override
	public List<ProductStoreTO> findByName(String param) {
		try {
			throw new OperationException("Find by name operation not realized");
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}
	
	
	public boolean productStoreExiste(ProductTO param) {
		try {
			List<ProductStore> productList =  getDbContext().select()
																.from(Tables.PRODUCT_HAS_STORE)
																.where(Tables.PRODUCT_HAS_STORE.PRODUCT_ID.equal(param.getId()))
																.and(Tables.PRODUCT_HAS_STORE.STORE_ID.equal(param.getStore().getId()))
															.fetch().into(ProductStore.class);
			if ( productList.size() > 0 ) { 
				return true;
			}else{
				return false;
			}
			
			
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}

	@Override
	public List<ProductStoreTO> findAll() {
		try {
			List<ProductStore> productList =  getDbContext().select().from(Tables.PRODUCT_HAS_STORE).fetch().into(ProductStore.class);
			return assemblyListTO(productList);			
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<ProductStoreTO> assemblyListTO(List<ProductStore> cousineList) {
			List<ProductStoreTO> cousineListTO = new ArrayList<ProductStoreTO>();
			cousineList.forEach( product-> cousineListTO.add(assemblyTO(product)) );
	return cousineListTO;

	}	

	private ProductStoreTO assemblyTO(ProductStore product) {
		ProductStoreTO productTO = new ProductStoreTO();
			productTO.setId(product.getId());
			productTO.setProduct(productDAO.findById(product.getProduct_id()));
			productTO.setStore(storeDAO.findById(product.getStore_id()));
		return productTO;
	}	

}
