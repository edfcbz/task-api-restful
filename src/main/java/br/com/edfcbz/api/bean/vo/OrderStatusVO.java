package br.com.edfcbz.api.bean.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "order", "orderStatus", "update"})
public class OrderStatusVO extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	@JsonProperty("id")	
	private Integer key;
	
	@JsonProperty("order")	
	private OrderVO order;
	
	@JsonProperty("orderStatus")	
	private List<OrderStatusDomainVO> orderStatusDomainList;

	@JsonProperty("update")
	private Date update;	
	
	public OrderStatusVO() {
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public OrderVO getOrder() {
		return order;
	}

	public void setOrder(OrderVO order) {
		this.order = order;
	}

	public List<OrderStatusDomainVO> getOrderStatusDomainList() {
		return orderStatusDomainList;
	}

	public void setOrderStatusDomainList(List<OrderStatusDomainVO> orderStatusDomainList) {
		this.orderStatusDomainList = orderStatusDomainList;
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
		int result = super.hashCode();
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((orderStatusDomainList == null) ? 0 : orderStatusDomainList.hashCode());
		result = prime * result + ((update == null) ? 0 : update.hashCode());
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
		OrderStatusVO other = (OrderStatusVO) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (orderStatusDomainList == null) {
			if (other.orderStatusDomainList != null)
				return false;
		} else if (!orderStatusDomainList.equals(other.orderStatusDomainList))
			return false;
		if (update == null) {
			if (other.update != null)
				return false;
		} else if (!update.equals(other.update))
			return false;
		return true;
	}





}
