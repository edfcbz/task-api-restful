/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.idao;

import br.com.edfcbz.api.bean.DomainStatusOrder;
import br.com.edfcbz.api.dao.impl.IDomainStatusOrderDaoImpl;
import com.google.inject.ImplementedBy;

/**
 *
 * @author Eduardo
 */
@ImplementedBy(IDomainStatusOrderDaoImpl.class)
public interface IDomainStatusOrderDao  extends IDao<DomainStatusOrder> {
    
}
