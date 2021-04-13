/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import br.com.edfcbz.api.bean.OrderItem;
import br.com.edfcbz.api.bean.to.CustomerTO;
import br.com.edfcbz.api.bean.to.OrderItemTO;

/**
 *
 * @author Eduardo
 */
@JsonPropertyOrder({ "id", "date", "contact", "customer", "order items"})
public class OrderVO extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	@JsonProperty("id")	
	private Integer key;
	
	@JsonProperty("date")
	private Timestamp date;
	
	@JsonProperty("contact")
	private String contact;
	
	@JsonProperty("customer")
	private CustomerVO customer;
	
	@JsonProperty("order items")
	private List<OrderItemVO> listItem;
	
	public OrderVO() {
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	public List<OrderItemVO> getListItem() {
		return listItem;
	}

	public void setListItem(List<OrderItemVO> listItem) {
		this.listItem = listItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((listItem == null) ? 0 : listItem.hashCode());
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
		OrderVO other = (OrderVO) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (listItem == null) {
			if (other.listItem != null)
				return false;
		} else if (!listItem.equals(other.listItem))
			return false;
		return true;
	}
    
}
