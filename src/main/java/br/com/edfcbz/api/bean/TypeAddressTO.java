package br.com.edfcbz.api.bean;

public class TypeAddressTO {
	private Integer id;
	private String description_type;
	
	public TypeAddressTO() {}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description_type == null) ? 0 : description_type.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TypeAddressTO other = (TypeAddressTO) obj;
		if (description_type == null) {
			if (other.description_type != null)
				return false;
		} else if (!description_type.equals(other.description_type))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription_type() {
		return description_type;
	}
	public void setDescription_type(String description_type) {
		this.description_type = description_type;
	}
	
	
	
	
}
