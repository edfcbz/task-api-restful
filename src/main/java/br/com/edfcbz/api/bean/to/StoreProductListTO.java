package br.com.edfcbz.api.bean.to;

import java.util.List;

import br.com.edfcbz.api.bean.vo.ProductVO;
import br.com.edfcbz.api.bean.vo.StoreVO;

public class StoreProductListTO {

	private Integer id;
	private StoreTO store;
	private List<ProductTO> products;
	
	public StoreProductListTO() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StoreTO getStore() {
		return store;
	}

	public void setStore(StoreTO store) {
		this.store = store;
	}

	public List<ProductTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductTO> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
		StoreProductListTO other = (StoreProductListTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		return true;
	}


	
	
	
	
}
