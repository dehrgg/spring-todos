package com.dehrg.todos.db.dao.jpa;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.dehrg.todos.db.dao.GenericDao;
import com.dehrg.todos.model.PersistentEntity;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

public abstract class GenericJPADao<T extends PersistentEntity<K>, K extends Serializable> implements GenericDao<T, K> {

	@PersistenceContext
	private EntityManager entityManager;
	private Class<? extends T> type;
	
	public GenericJPADao(Class<? extends T> type) {
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
	public List<T> readAll() {
		EntityPathBase<? extends T> tableDef = getDefinition();
		return unboundedList(newQuery().from(tableDef).list(tableDef));
	}
	
	@Override
	public List<T> readAll(long limit) {
		if (limit <= 0) {
			return readAll();
		}
		EntityPathBase<? extends T> tableDef = getDefinition();
		return unboundedList(newQuery().from(tableDef).limit(limit).list(tableDef));
	}
	
	@Override
	@Transactional
	public T update(T object) {
		if (read(object.getId()) == null)
				return null;
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
	
	@Override
	public void reset(T object) {
		entityManager.refresh(object);
	}
	
	@Override
	public T instanceOfPersistentClass() {
		try {
			return type.newInstance();
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		return null;
	}
	
	protected JPQLQuery newQuery() {
		return new JPAQuery(entityManager);
	}
	
	protected List<T> unboundedList(List<? extends T> toConvert) {
		return new LinkedList<T>(toConvert);
	}
	
	protected abstract EntityPathBase<? extends T> getDefinition();
	
	public Class<? extends T> getType() {
		return type;
	}

	public void setType(Class<? extends T> type) {
		this.type = type;
	}
}
