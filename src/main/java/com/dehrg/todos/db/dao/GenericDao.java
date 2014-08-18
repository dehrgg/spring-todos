package com.dehrg.todos.db.dao;

import java.io.Serializable;
import java.util.List;

import com.dehrg.todos.model.PersistentEntity;

public interface GenericDao <T extends PersistentEntity<K>, K extends Serializable> {
	
	public T create(T newObject);
	
	public T read(K key);
	
	public List<T> readAll();
	
	public List<T> readAll(long limit);
	
	public T update(T object);	
	
	public void delete(T object);
	
	public boolean delete(K key);
	
	public void reset(T object);
	
}
