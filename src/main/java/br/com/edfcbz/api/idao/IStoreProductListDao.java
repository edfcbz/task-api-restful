/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.idao;

import com.google.inject.ImplementedBy;

import br.com.edfcbz.api.bean.to.StoreProductListTO;
import br.com.edfcbz.api.dao.impl.IStoreProductListDaoImpl;

/**
 *
 * @author Eduardo
 */
@ImplementedBy(IStoreProductListDaoImpl.class)
public interface IStoreProductListDao extends IDao<StoreProductListTO>{
    
}
