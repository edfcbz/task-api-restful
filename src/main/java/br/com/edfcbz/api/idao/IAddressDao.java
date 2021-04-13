/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.idao;

//import ca.skipthedishes.dao.impl.IAddressDaoImpl;
import com.google.inject.ImplementedBy;

import br.com.edfcbz.api.bean.to.AddressTO;
import br.com.edfcbz.api.dao.impl.IAddressDaoImpl;

/**
 *.
 * @author Eduardo
 */
@ImplementedBy(IAddressDaoImpl.class)
public interface IAddressDao   extends IDao<AddressTO> {
    
}
