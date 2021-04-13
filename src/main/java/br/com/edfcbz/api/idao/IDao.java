package br.com.edfcbz.api.idao;

import java.util.List;

public interface IDao<T> {

	T save(T param) throws Throwable;;
	
	T update(T param) throws Throwable;
	
	int delete(T param) throws Throwable;
	
	int delete(Integer param) throws Throwable;
	
	T findById(Integer param) throws Throwable;
        
    List<T> findByName(String param) throws Throwable;
	
	List<T> findAll() throws Throwable;
	
}
