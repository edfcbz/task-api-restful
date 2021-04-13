/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.idao;

//import ca.skipthedishes.dao.impl.IAddressDaoImpl;
import com.google.inject.ImplementedBy;

import br.com.edfcbz.api.bean.to.NeighborhoodTO;
import br.com.edfcbz.api.dao.impl.INeighborhoodDaoImpl;

/**
 *.
 * @author Eduardo
 */
@ImplementedBy(INeighborhoodDaoImpl.class)
public interface INeighborhoodDao   extends IDao<NeighborhoodTO> {
    
}
