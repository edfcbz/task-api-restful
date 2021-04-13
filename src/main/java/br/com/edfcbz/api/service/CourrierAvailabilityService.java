package br.com.edfcbz.api.service;
import br.com.edfcbz.api.bean.CourrierAvailability;
import br.com.edfcbz.api.dao.impl.ICourrierAvailabilityDaoImpl;
import br.com.edfcbz.api.service.interfaces.IService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourrierAvailabilityService implements IService<CourrierAvailability> {

    @Override
    public CourrierAvailability save(CourrierAvailability param) throws Throwable {
        return new ICourrierAvailabilityDaoImpl().save(param);
    }

    @Override
    public CourrierAvailability update(CourrierAvailability param) throws Throwable {
        return new ICourrierAvailabilityDaoImpl().update(param);
    }

    @Override
    public int delete(CourrierAvailability param) throws Throwable {
        return new ICourrierAvailabilityDaoImpl().delete(param);
    }

    @Override
    public int delete(Integer param) throws Throwable {
        return new ICourrierAvailabilityDaoImpl().delete(param);
    }

    @Override
    public CourrierAvailability findById(Integer param) throws Throwable {
        return new ICourrierAvailabilityDaoImpl().findById(param);
    }

    @Override
    public List<CourrierAvailability> findByName(String param){
        try {
            return new ICourrierAvailabilityDaoImpl().findByName(param);
        } catch (Throwable ex) {
            Logger.getLogger(CourrierAvailabilityService.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    @Override
    public List<CourrierAvailability> findAll() throws Throwable {
        return new ICourrierAvailabilityDaoImpl().findAll();
    }

}

    
