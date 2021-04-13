package br.com.edfcbz.api.idao;

import com.google.inject.ImplementedBy;

import br.com.edfcbz.api.bean.to.CustomerAddressTO;
import br.com.edfcbz.api.dao.impl.ICustomerAddressDaoImpl;

@ImplementedBy(ICustomerAddressDaoImpl.class)
    public interface ICustomerAddressDao extends IDao<CustomerAddressTO>{
}
