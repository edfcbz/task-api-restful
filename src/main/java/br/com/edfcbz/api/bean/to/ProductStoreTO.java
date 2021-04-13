/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean.to;

import br.com.edfcbz.api.bean.vo.ProductVO;
import br.com.edfcbz.api.bean.vo.StoreVO;

/**
 *
 * @author Eduardo
 */
public class ProductStoreTO {

    private Integer id;
    private ProductTO product;
    private StoreTO store;

    public ProductStoreTO() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductTO getProduct() {
		return product;
	}

	public void setProduct(ProductTO product) {
		this.product = product;
	}

	public StoreTO getStore() {
		return store;
	}

	public void setStore(StoreTO store) {
		this.store = store;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((store == null) ? 0 : store.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductStoreTO other = (ProductStoreTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		return true;
	}



    
}
