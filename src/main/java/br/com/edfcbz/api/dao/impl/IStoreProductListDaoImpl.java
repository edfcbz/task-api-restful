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

import br.com.edfcbz.api.bean.StoreProduct;
import br.com.edfcbz.api.bean.to.ProductTO;
import br.com.edfcbz.api.bean.to.StoreProductListTO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.idao.IStoreProductListDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IStoreProductListDaoImpl extends GenericDao implements IStoreProductListDao {
	
	@Autowired
	IStoreProductListDaoImpl storeProductListDAO;
	
	@Autowired
	IProductDaoImpl productDAO;
	
	@Autowired
	IStoreDaoImpl storeDAO;	
	
	@Override
	public StoreProductListTO save(StoreProductListTO param) {
		try {
//			ProductHasStoreRecord StoreProductRecord = getDbContext().newRecord(Tables.PRODUCT_HAS_STORE);
//			StoreProductRecord.setProductId(param.getProduct().getId());
//			StoreProductRecord.setStoreId(param.getStore().getId());
//			StoreProductRecord.store();
//			
//			return findById(StoreProductRecord.getId());
			throw new OperationException("Insert operation  not realized");
		} catch (Throwable e) {
			throw new OperationException("Insert operation  not realized");
		}
	}

	@Override
	public StoreProductListTO update(StoreProductListTO param) {
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
	public int delete(Integer param) {
		try {
			return getDbContext().fetchOne(Tables.PRODUCT_HAS_STORE, Tables.PRODUCT_HAS_STORE.PRODUCT_ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}
	}

	@Override
	public StoreProductListTO findById(Integer param) {
		try {
			StoreProduct storeProduct = getDbContext().fetch(Tables.PRODUCT_HAS_STORE, Tables.PRODUCT_HAS_STORE.ID.eq(param)).into(StoreProduct.class).get(0);
			return assemblyTO(storeProduct);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	
	@Override
	public List<StoreProductListTO> findByName(String param) {
		try {
			throw new OperationException("Find by name operation not realized");
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}
	
	//esta consulta deve retornar apenas as lojas que estão associadas ao produto pesquisado
	@Override
	public List<StoreProductListTO> findAll() {
		try {
			List<StoreProduct> StoreProductList =  getDbContext()
													.select()
													.from(Tables.PRODUCT_HAS_STORE)
													.fetch().into(StoreProduct.class);
			return assemblyListTO(StoreProductList);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	
	public boolean StoreProductExiste(ProductTO param) {
		try {
			List<StoreProduct> productList =  getDbContext().select()
																.from(Tables.PRODUCT_HAS_STORE)
																.where(Tables.PRODUCT_HAS_STORE.PRODUCT_ID.equal(param.getId()))
																.and(Tables.PRODUCT_HAS_STORE.STORE_ID.equal(param.getStore().getId()))
															.fetch().into(StoreProduct.class);
			if ( productList.size() > 0 ) { 
				return true;
			}else{
				return false;
			}
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}

	
	private List<StoreProductListTO> assemblyListTO(List<StoreProduct> storeProductList) {
			List<StoreProductListTO> StoreProductListTO = new ArrayList<StoreProductListTO>();
			storeProductList.forEach( StoreProduct-> StoreProductListTO.add(assemblyTO(StoreProduct)) );
	return StoreProductListTO;

	}	

	private StoreProductListTO assemblyTO( StoreProduct storeProduct) {
		StoreProductListTO productTO = new StoreProductListTO();
			productTO.setId(storeProduct.getId());
			productTO.setStore( storeDAO.findById(storeProduct.getStore_id()));
			productTO.setProducts( findByStoreId(storeProduct.getProduct_id()));
		return productTO;
	}	
	
	public List<ProductTO> findByStoreId(Integer param) {
		List<ProductTO> storeListTO = new ArrayList<>();
		try {
			List<StoreProduct> storeProductList =  getDbContext().select().from(Tables.PRODUCT_HAS_STORE).where(Tables.PRODUCT_HAS_STORE.STORE_ID.equal(param)).fetch().into(StoreProduct.class);
			storeProductList.forEach(  storeProduct -> { storeListTO.add( productDAO.findById(storeProduct.getProduct_id()));
			}  );
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
		return storeListTO;
	}

	@Override
	public int delete(StoreProductListTO param) throws Throwable {
		// TODO Auto-generated method stub
		return 0;
	}

}
