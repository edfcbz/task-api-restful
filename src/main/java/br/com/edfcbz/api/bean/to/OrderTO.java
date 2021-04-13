/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean.to;

import java.sql.Timestamp;
import java.util.List;

import br.com.edfcbz.api.bean.OrderItem;

/**
 *
 * @author Eduardo
 */
public class OrderTO {

	private Integer id;
	private Timestamp date;
	private String contact;
	private CustomerTO customer;
	private DeliveryTO delivery;
	private List<OrderItemTO> listItem;
	
	public OrderTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public CustomerTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerTO customer) {
		this.customer = customer;
	}

	public DeliveryTO getDelivery() {
		return delivery;
	}

	public void setDelivery(DeliveryTO delivery) {
		this.delivery = delivery;
	}

	public List<OrderItemTO> getListItem() {
		return listItem;
	}

	public void setListItem(List<OrderItemTO> listItem) {
		this.listItem = listItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((delivery == null) ? 0 : delivery.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listItem == null) ? 0 : listItem.hashCode());
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
		OrderTO other = (OrderTO) obj;
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
		if (delivery == null) {
			if (other.delivery != null)
				return false;
		} else if (!delivery.equals(other.delivery))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listItem == null) {
			if (other.listItem != null)
				return false;
		} else if (!listItem.equals(other.listItem))
			return false;
		return true;
	}
	
  
    

    
}
