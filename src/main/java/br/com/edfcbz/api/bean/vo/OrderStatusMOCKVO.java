package br.com.edfcbz.api.bean.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "order_id", "order_status_domain_id"})
public class OrderStatusMOCKVO extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	@JsonProperty("id")	
	private Integer key;
	
	@JsonProperty("order_id")	
	private Integer order_id;
	
	@JsonProperty("order_status_domain_id")	
	private Integer order_status_domain_id;

	public OrderStatusMOCKVO() {
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getOrder_status_domain_id() {
		return order_status_domain_id;
	}

	public void setOrder_status_domain_id(Integer order_status_domain_id) {
		this.order_status_domain_id = order_status_domain_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((order_status_domain_id == null) ? 0 : order_status_domain_id.hashCode());
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
		OrderStatusMOCKVO other = (OrderStatusMOCKVO) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (order_status_domain_id == null) {
			if (other.order_status_domain_id != null)
				return false;
		} else if (!order_status_domain_id.equals(other.order_status_domain_id))
			return false;
		return true;
	}

	

}
