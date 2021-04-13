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

import br.com.edfcbz.api.bean.Product;
import br.com.edfcbz.api.bean.to.ProductTO;
import br.com.edfcbz.api.bean.vo.ProductVO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.ProductRecord;
import br.com.edfcbz.api.idao.IProductDao;

/**
 *
 * @author Eduardo
 */
@Service
public class IProductDaoImpl extends GenericDao implements IProductDao {

	@Autowired 
	IProductStoreDaoImpl productStoreDAO; 
	
	@Override
	public ProductTO save(ProductTO param) {
		List<ProductTO> productTOList = findByName(param.getName());
		if ( productTOList.size() == 0 ) { //returno nulo verificar depois TODO
			
			try {
				ProductRecord productRecord = getDbContext().newRecord(Tables.PRODUCT);
				productRecord.setName(param.getName());
				productRecord.setDescription(param.getDescription());
				productRecord.setPrice(param.getPrice());
				productRecord.setProductimage(param.getProductImage().getBytes());
				productRecord.store();
				
				return findById(productRecord.getId());
				
			} catch (Throwable e) {
				throw new OperationException("Insert operation not realized");
			}
		}else{
			param.setId(productTOList.get(0).getId());
			return findById(productTOList.get(0).getId());
		}
	}

	@Override
	public ProductTO update(ProductTO param) {
		try {
			getDbContext().update(Tables.PRODUCT)
				.set(Tables.PRODUCT.NAME, param.getName())
				.set(Tables.PRODUCT.DESCRIPTION, param.getDescription())
				.set(Tables.PRODUCT.NAME, param.getName())
				.set(Tables.PRODUCT.PRICE, param.getPrice())
				.set(Tables.PRODUCT.PRODUCTIMAGE, param.getProductImage().getBytes())
				.where(Tables.PRODUCT.ID.eq(param.getId()))
					.execute();
			return findById(param.getId());
		} catch (Throwable e) {
			throw new OperationException("Update operation not realized");
		}

	}

	@Override
	public int delete(ProductTO param) {
		return delete(param.getId());
	}

	@Override
	public int delete(Integer param) {
		try {
			return getDbContext().fetchOne(Tables.PRODUCT, Tables.PRODUCT.ID.eq(param)).delete();
		} catch (Throwable e) {
			throw new OperationException("Delete operation not realized");
		}
	}

	@Override
	public ProductTO findById(Integer param) {
		try {
			Product product = getDbContext().fetch(Tables.PRODUCT, Tables.PRODUCT.ID.eq(param)).into(Product.class).get(0);
			return assemblyTO(product);
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}

	@Override
	public List<ProductTO> findByName(String param) {
		try {
			List<Product> productList = getDbContext().fetch(Tables.PRODUCT, Tables.PRODUCT.NAME.eq(param)).into(Product.class);
			if (productList.size() > 0) {
				return assemblyListTO(productList);
			}
			else
				return new ArrayList<ProductTO>();
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}
	
	public ProductTO findByDescription(String param) {
		try {
			 Product product = getDbContext().fetch(Tables.PRODUCT, Tables.PRODUCT.NAME.eq(param)).into(Product.class).get(0);
			if ( !product.equals(null)) {
				return assemblyTO(product);
			}
			else
				return new ProductTO();
		} catch (Throwable e) {
			throw new OperationException("Find by name operation not realized");
		}
	}	

	@Override
	public List<ProductTO> findAll() {
		try {
			List<Product> productList =  getDbContext().select().from(Tables.PRODUCT).fetch().into(Product.class);
			return assemblyListTO(productList);			
		} catch (Throwable e) {
			throw new OperationException("Find by id operation not realized");
		}
	}
	
	private List<ProductTO> assemblyListTO(List<Product> cousineList) {
			List<ProductTO> cousineListTO = new ArrayList<ProductTO>();
			cousineList.forEach( product-> cousineListTO.add(assemblyTO(product)) );
	return cousineListTO;

	}	

	private ProductTO assemblyTO(Product product) {
		ProductTO productTO = new ProductTO();
			productTO.setId(product.getId());
			productTO.setDescription(product.getDescription());
			productTO.setName(product.getName());
			productTO.setPrice(product.getPrice());
			productTO.setProductImage(product.getProductImage());
		return productTO;
	}	

}
