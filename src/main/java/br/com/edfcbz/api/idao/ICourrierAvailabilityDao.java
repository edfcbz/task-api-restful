/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.idao;

import br.com.edfcbz.api.bean.CourrierAvailability;
import br.com.edfcbz.api.dao.impl.IAddressDaoImpl;
import com.google.inject.ImplementedBy;

/**
 *.
 * @author Eduardo
 */
@ImplementedBy(IAddressDaoImpl.class)
public interface ICourrierAvailabilityDao   extends IDao<CourrierAvailability> {
    
}