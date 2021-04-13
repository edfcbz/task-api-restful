package br.com.edfcbz.api.bean.to;

import java.util.Date;
import java.util.List;

public class OrderStatusTO {
	private Integer id;
	private OrderTO order;
	private OrderStatusDomainTO orderStatusDomain;
	private List<OrderStatusDomainTO> orderStatusDomainList;
	private Date update;

	public OrderStatusTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderTO getOrder() {
		return order;
	}

	public void setOrder(OrderTO order) {
		this.order = order;
	}

	public OrderStatusDomainTO getOrderStatusDomain() {
		return orderStatusDomain;
	}

	public void setOrderStatusDomain(OrderStatusDomainTO orderStatusDomain) {
		this.orderStatusDomain = orderStatusDomain;
	}

	public List<OrderStatusDomainTO> getOrderStatusDomainList() {
		return orderStatusDomainList;
	}

	public void setOrderStatusDomainList(List<OrderStatusDomainTO> orderStatusDomainList) {
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
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((orderStatusDomain == null) ? 0 : orderStatusDomain.hashCode());
		result = prime * result + ((orderStatusDomainList == null) ? 0 : orderStatusDomainList.hashCode());
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
		OrderStatusTO other = (OrderStatusTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (orderStatusDomain == null) {
			if (other.orderStatusDomain != null)
				return false;
		} else if (!orderStatusDomain.equals(other.orderStatusDomain))
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
