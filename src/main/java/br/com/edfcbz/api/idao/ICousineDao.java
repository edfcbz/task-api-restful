package br.com.edfcbz.api.idao;

import com.google.inject.ImplementedBy;

import br.com.edfcbz.api.bean.to.CousineTO;
import br.com.edfcbz.api.dao.impl.ICousineDaoImpl;

@ImplementedBy(ICousineDaoImpl.class)
    public interface ICousineDao extends IDao<CousineTO>{
}
