package br.com.ejbapp.generics;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GenericDAO <T, ID extends Serializable> implements CrudDAO<T, Serializable>	{

	public GenericDAO(Class<T> persistedClass) {
		this.persistedClass = persistedClass;
	}

	public GenericDAO() {
	} 

	@PersistenceContext(unitName="ejbapp-app")
	private EntityManager em;
	
	private Class<T> persistedClass;
	

	@TransactionAttribute()
	public void save(T entity) {
		em.persist(entity);
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public T findById(Serializable primaryKey) {
		return em.find(persistedClass, primaryKey);
	}

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)	
	public List<T> findAll() {
		return em.createQuery(" SELECT entity FROM "+ persistedClass.getSimpleName() +" entity").getResultList();
	}

	public long count() {
		return (Long) em.createNativeQuery("SELECT count(*) FROM " +persistedClass.getSimpleName() ).getSingleResult();
	}

	public void delete(T entity) {
		em.remove(entity);
		
	}

	public boolean existsById(Serializable primaryKey) {
		return findById(primaryKey) != null;
	}

	
	
}
