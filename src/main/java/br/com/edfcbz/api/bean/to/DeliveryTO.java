/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean.to;

import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class DeliveryTO {

    private Integer id;
    private CourrierTO courrier;
    private Date update; 

    public DeliveryTO() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CourrierTO getCourrier() {
		return courrier;
	}

	public void setCourrier(CourrierTO courrier) {
		this.courrier = courrier;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courrier == null) ? 0 : courrier.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((update == null) ? 0 : update.hashCode());
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
		DeliveryTO other = (DeliveryTO) obj;
		if (courrier == null) {
			if (other.courrier != null)
				return false;
		} else if (!courrier.equals(other.courrier))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (update == null) {
			if (other.update != null)
				return false;
		} else if (!update.equals(other.update))
			return false;
		return true;
	}



}
