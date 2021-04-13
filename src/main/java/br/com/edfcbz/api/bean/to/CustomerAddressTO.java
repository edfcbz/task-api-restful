package br.com.edfcbz.api.bean.to;

import br.com.edfcbz.api.bean.TypeAddressTO;

public class CustomerAddressTO {
	private Integer id;
	private CustomerTO customer;
	private TypeAddressTO type;
	private AddressTO address;
	
	
	public CustomerAddressTO() {}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public CustomerTO getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerTO customer) {
		this.customer = customer;
	}


	public TypeAddressTO getType() {
		return type;
	}


	public void setType(TypeAddressTO type) {
		this.type = type;
	}


	public AddressTO getAddress() {
		return address;
	}


	public void setAddress(AddressTO address) {
		this.address = address;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		CustomerAddressTO other = (CustomerAddressTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	

}
