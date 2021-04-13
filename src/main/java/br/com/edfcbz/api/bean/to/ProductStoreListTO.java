package br.com.edfcbz.api.bean.to;

import java.util.List;

import br.com.edfcbz.api.bean.vo.ProductVO;
import br.com.edfcbz.api.bean.vo.StoreVO;

public class ProductStoreListTO {

	private Integer id;
	private ProductTO product;
	private List<StoreTO> stores;
	
	public ProductStoreListTO() {}

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

	public List<StoreTO> getStores() {
		return stores;
	}

	public void setStores(List<StoreTO> stores) {
		this.stores = stores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((stores == null) ? 0 : stores.hashCode());
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
		ProductStoreListTO other = (ProductStoreListTO) obj;
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
		if (stores == null) {
			if (other.stores != null)
				return false;
		} else if (!stores.equals(other.stores))
			return false;
		return true;
	}

	
	
	
	
}
