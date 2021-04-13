package br.com.edfcbz.api.bean;

public class CourrierNeighborhood {

	private Integer id;
	private Integer courrier_id;
	private Integer neighborhood_id;

	public CourrierNeighborhood() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourrier_id() {
		return courrier_id;
	}

	public void setCourrier_id(Integer courrier_id) {
		this.courrier_id = courrier_id;
	}

	public Integer getNeighborhood_id() {
		return neighborhood_id;
	}

	public void setNeighborhood_id(Integer neighborhood_id) {
		this.neighborhood_id = neighborhood_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courrier_id == null) ? 0 : courrier_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((neighborhood_id == null) ? 0 : neighborhood_id.hashCode());
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
		CourrierNeighborhood other = (CourrierNeighborhood) obj;
		if (courrier_id == null) {
			if (other.courrier_id != null)
				return false;
		} else if (!courrier_id.equals(other.courrier_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (neighborhood_id == null) {
			if (other.neighborhood_id != null)
				return false;
		} else if (!neighborhood_id.equals(other.neighborhood_id))
			return false;
		return true;
	}
	
	
	
}
