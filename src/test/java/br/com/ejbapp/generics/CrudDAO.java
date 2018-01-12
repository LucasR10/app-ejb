package br.com.ejbapp.generics;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

@Local
public interface CrudDAO <T, ID extends Serializable>	{

	
	void save(T entity);
	
	void update(T entity);
	
	void delete(T entity);     
	
	T  findById(ID primaryKey); 
	
	List	<T> findAll();         
	
	boolean existsById(ID primaryKey);
}
