package br.com.edfcbz.api.bean.to;

public class OrderStatusMOCKTO{

	private Integer id;
	
	private Integer order_id;
	
	private Integer order_status_domain_id;

	public OrderStatusMOCKTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((order_status_domain_id == null) ? 0 : order_status_domain_id.hashCode());
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
		OrderStatusMOCKTO other = (OrderStatusMOCKTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
