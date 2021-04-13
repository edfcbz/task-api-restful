/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.idao;

import com.google.inject.ImplementedBy;

import br.com.edfcbz.api.bean.to.ProductStoreListTO;
import br.com.edfcbz.api.dao.impl.IProductStoreListDaoImpl;

/**
 *
 * @author Eduardo
 */
@ImplementedBy(IProductStoreListDaoImpl.class)
public interface IProductStoreListDao extends IDao<ProductStoreListTO>{
    
}
