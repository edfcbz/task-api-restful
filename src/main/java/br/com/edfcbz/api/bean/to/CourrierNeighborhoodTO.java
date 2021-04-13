package br.com.edfcbz.api.bean.to;

public class CourrierNeighborhoodTO {

	private Integer id;
	private CourrierTO courrier;
	private NeighborhoodTO neighborhood;

	public CourrierNeighborhoodTO() {}

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

	public NeighborhoodTO getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(NeighborhoodTO neighborhood) {
		this.neighborhood = neighborhood;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courrier == null) ? 0 : courrier.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((neighborhood == null) ? 0 : neighborhood.hashCode());
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
		CourrierNeighborhoodTO other = (CourrierNeighborhoodTO) obj;
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
		if (neighborhood == null) {
			if (other.neighborhood != null)
				return false;
		} else if (!neighborhood.equals(other.neighborhood))
			return false;
		return true;
	}

	
	
	
}
