package com.dehrg.todos.db.dao;

import java.io.Serializable;
import java.util.List;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.path.EntityPathBase;

public interface GenericDao <T, K extends Serializable> {
	
	public T create(T newObject);
	
	public T read(K key);
	
	public List<T> readAll();
	
	public List<T> readAll(long limit);
	
	public T update(T object);	
	
	public void delete(T object);
	
	public boolean delete(K key);
	
	public void reset(T object);
	
	public JPQLQuery newQuery();
	
	public EntityPathBase<? extends T> getDefinition();
	
}
