/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.idao;

import com.google.inject.ImplementedBy;

import br.com.edfcbz.api.bean.to.StoreTO;
import br.com.edfcbz.api.dao.impl.IStoreDaoImpl;

/**
 *
 * @author Eduardo
 */
@ImplementedBy(IStoreDaoImpl.class)
public interface IStoreDao extends IDao<StoreTO> {
    
}
