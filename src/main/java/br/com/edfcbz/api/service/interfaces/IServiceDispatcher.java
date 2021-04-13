package br.com.edfcbz.api.service.interfaces;

import java.util.List;

public interface IServiceDispatcher<TO,T> {

    TO save(T param) throws Throwable;

    TO update(T param) throws Throwable;

    int delete(T param) throws Throwable;

    int delete(Integer param) throws Throwable;

    TO findById(Integer param) throws Throwable;

    List<TO> findByName(String param) throws Throwable;

    List<TO> findAll() throws Throwable;

}
