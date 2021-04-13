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
import br.com.edfcbz.api.bean.to.ProductStoreListTO;
import br.com.edfcbz.api.bean.to.ProductTO;
import br.com.edfcbz.api.bean.to.StoreTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.idao.IProductStoreListDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IProductStoreListDaoImpl extends GenericDao implements IProductStoreListDao {

	@Autowired
	IProductDaoImpl productDAO;
	
	@Autowired
	IStoreDaoImpl storeDAO;
	
	
	@Override
	public ProductStoreListTO save(ProductStoreListTO param) {
		try {
//			ProductHasStoreRecord productStoreRecord = getDbContext().newRecord(Tables.PRODUCT_HAS_STORE);
//			productStoreRecord.setProductId(param.getProduct().getId());
//			productStoreRecord.setStoreId(param.getStore().getId());
//			productStoreRecord.store();
//			
//			return findById(productStoreRecord.getId());
			throw new OperationException("Insert operation  not realized");
		} catch (Throwable e) {
			throw new OperationException("Insert operation  not realized");
		}
	}

	@Override
	public ProductStoreListTO update(ProductStoreListTO param) {
		try {
//			getDbContext().update(Tables.PRODUCT_HAS_STORE)
//				.set(Tables.PRODUCT_HAS_STORE.PRODUCT_ID, param.getId())
//				.set(Tables.PRODUCT_HAS_STORE.STORE_ID, param.getStore().getId())
//				.where(Tables.PRODUCT_HAS_STORE.ID.eq(param.getId()))
//					.execute();
//			return findById(param.getId());
			throw new OperationException("Insert operation  not realized");
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}

	}

	@Override
	public int delete(ProductStoreListTO param) {
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
	public ProductStoreListTO findById(Integer param) {
		try {
			ProductStore productStore = getDbContext().fetch(Tables.PRODUCT_HAS_STORE, Tables.PRODUCT_HAS_STORE.ID.eq(param)).into(ProductStore.class).get(0);
			return assemblyTO(productStore);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	@Override
	public List<ProductStoreListTO> findByName(String param) {
		try {
			throw new OperationException("Find by name operation not realized");
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}
	
	public List<ProductStoreListTO> findByProductId(Integer param) {
		try {
			List<ProductStore> productStoreList = getDbContext()
													.select()
													.from(Tables.PRODUCT_HAS_STORE)
													.where(Tables.PRODUCT_HAS_STORE.PRODUCT_ID.equal(param))
													.fetch().into(ProductStore.class);
			List<ProductStoreListTO> list = assemblyListTO(productStoreList);
			return list;
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	//esta consulta deve retornar apenas as lojas que estão associadas ao produto pesquisado
	@Override
	public List<ProductStoreListTO> findAll() {
		try {
			List<ProductStore> productStoreList =  getDbContext()
													.select()
													.from(Tables.PRODUCT_HAS_STORE)
													.fetch().into(ProductStore.class);
			return assemblyListTO(productStoreList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
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

	
	private List<ProductStoreListTO> assemblyListTO(List<ProductStore> productStoreList) {
			List<ProductStoreListTO> productStoreListTO = new ArrayList<ProductStoreListTO>();
			productStoreList.forEach( productStore-> productStoreListTO.add(assemblyTO(productStore)) );
	return productStoreListTO;

	}	

	private ProductStoreListTO assemblyTO(ProductStore productStore) {
		ProductStoreListTO productTO = new ProductStoreListTO();
			productTO.setId(productStore.getId());
			productTO.setProduct(productDAO.findById(productStore.getProduct_id()));
			productTO.setStores(findByStoreId(productStore.getProduct_id()));
		return productTO;
	}
	
	public List<StoreTO> findByStoreId(Integer param) {
		List<StoreTO> storeListTO = new ArrayList<>();
		try {
			List<ProductStore> productStoreList =  getDbContext().select().from(Tables.PRODUCT_HAS_STORE).where(Tables.PRODUCT_HAS_STORE.PRODUCT_ID.equal(param)).fetch().into(ProductStore.class);
			productStoreList.forEach(  productStore -> { 
				storeListTO.add(storeDAO.findById(productStore.getStore_id()));
			}  );
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
		return storeListTO;
	}	

}
