/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.idao;

import com.google.inject.ImplementedBy;

import br.com.edfcbz.api.bean.to.DeliveryTO;
import br.com.edfcbz.api.dao.impl.IDeliveryDaoImpl;

/**
 *
 * @author Eduardo
 */
@ImplementedBy(IDeliveryDaoImpl.class)
public interface IDeliveryDao extends IDao<DeliveryTO> {
    
}
