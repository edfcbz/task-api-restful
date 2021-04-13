/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean;

/**
 *
 * @author Eduardo
 */
public class Store {

    private Integer id;
    private String name;
    private String logo;
    private Double deliveryfee;
    private Double deliveryfeefreeover;
    private Integer address_id;

    public Store() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address_id == null) ? 0 : address_id.hashCode());
		result = prime * result + ((deliveryfee == null) ? 0 : deliveryfee.hashCode());
		result = prime * result + ((deliveryfeefreeover == null) ? 0 : deliveryfeefreeover.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Store other = (Store) obj;
		if (address_id == null) {
			if (other.address_id != null)
				return false;
		} else if (!address_id.equals(other.address_id))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
