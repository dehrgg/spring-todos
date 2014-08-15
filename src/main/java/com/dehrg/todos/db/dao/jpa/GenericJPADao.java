package com.dehrg.todos.db.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.dehrg.todos.db.dao.GenericDao;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

public abstract class GenericJPADao<T, K extends Serializable> implements GenericDao<T, K> {

	@PersistenceContext
	private EntityManager entityManager;
	private Class<T> type;
	
	public GenericJPADao(Class<T> type) {
		setType(type);
	}
	
	@Override
	@Transactional
	public T create(T newObject) {
		entityManager.persist(newObject);
		return newObject;
	}

	@Override
	public T read(K key) {
		return entityManager.find(type, key);
	}
	
	@Override
	public List<? extends T> readAll() {
		EntityPathBase<? extends T> tableDef = getDefinition();
		return newQuery().from(tableDef).list(tableDef);
	}
	
	@Override
	public List<? extends T> readAll(long limit) {
		if (limit <= 0) {
			return readAll();
		}
		EntityPathBase<? extends T> tableDef = getDefinition();
		return newQuery().from(tableDef).limit(limit).list(tableDef);
	}
	
	@Override
	@Transactional
	public T update(T object) {
		return entityManager.merge(object);	
	}
	
	@Override
	@Transactional
	public void delete(T object) {
		entityManager.remove(object);
	}
	
	@Override
	public boolean delete(K key) {
		T object = read(key);
		if (object != null) {
			delete(object);
			return true;
		}
		return false;
	}
	
	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public void reset(T object) {
		entityManager.refresh(object);
	}
	
	@Override
	public JPQLQuery newQuery() {
		return new JPAQuery(entityManager);
	}
}
