/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean.vo;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import br.com.edfcbz.api.bean.to.AddressTO;

/**
 *
 * @author Eduardo
 */
@JsonPropertyOrder({ "id", "name", "logo", "deliveryfee", "deliveryfeefreeover", "address"})
public class StoreVO extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	@JsonProperty("id")	
	private Integer key;
	
	@JsonProperty("name")		
    private String name;
	
	@JsonProperty("logo")	
    private String logo;
	
	@JsonProperty("deliveryfee")	
    private Double deliveryfee;
	
	@JsonProperty("deliveryfeefreeover")	
    private Double deliveryfeefreeover;
	
	@JsonProperty("address")	
    private AddressVO address;

    public StoreVO() {
    }

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Double getDeliveryfee() {
		return deliveryfee;
	}

	public void setDeliveryfee(Double deliveryfee) {
		this.deliveryfee = deliveryfee;
	}

	public Double getDeliveryfeefreeover() {
		return deliveryfeefreeover;
	}

	public void setDeliveryfeefreeover(Double deliveryfeefreeover) {
		this.deliveryfeefreeover = deliveryfeefreeover;
	}

	public AddressVO getAddress() {
		return address;
	}

	public void setAddress(AddressVO address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((deliveryfee == null) ? 0 : deliveryfee.hashCode());
		result = prime * result + ((deliveryfeefreeover == null) ? 0 : deliveryfeefreeover.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreVO other = (StoreVO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (deliveryfee == null) {
			if (other.deliveryfee != null)
				return false;
		} else if (!deliveryfee.equals(other.deliveryfee))
			return false;
		if (deliveryfeefreeover == null) {
			if (other.deliveryfeefreeover != null)
				return false;
		} else if (!deliveryfeefreeover.equals(other.deliveryfeefreeover))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}




    
    
}
