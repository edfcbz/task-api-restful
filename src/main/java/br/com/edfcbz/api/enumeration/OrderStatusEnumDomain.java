package br.com.edfcbz.api.enumeration;

public enum OrderStatusEnumDomain {
	CONCELED_BY_CUSTOMER("Canceled by customer"),
	CONCELED_BY_STORE("Canceled by store"),
	ON_THE_WAY("On the way"),
	CUSTOMER_RECEIVED("Customer received"),
	LOST_BY_COURRIER("Lost by courrier"),
	STORE_RECEIVED("Received by store"),
	ADDRESS_NOT_LOCATED("Address not located"),
	RETURNED_BY_COURRIER("Received by courrier"),
	RECEIVED_BY_SYSTEM("Received by system"),
	RETURNED_BY_CUSTOMER("Return by customer");
	
    private String descricao;
 
    OrderStatusEnumDomain(String descricao) {
        this.descricao = descricao;
        getDescricao();
    }
 
    public String getDescricao() {
        return descricao;
    }
}

