package com.dehrg.todos.controller.api;

import java.io.Serializable;

import org.springframework.web.bind.annotation.RestController;

@RestController	
public abstract class GenericAPIController<T, K extends Serializable>  {
	
	
//	public List<T> index() {
//		return getDao().readAll();
//	}
//	
//	public T get(@RequestParam K id) {
//		return getDao().read(id);
//	}
//	
//	public void delete(@RequestParam K id) {
//		getDao().delete(id);
//	}
//	
//	public T create(@RequestBody T object) {
//		return getDao().create(object);
//	}
//	
//	public T update(@RequestBody T object) {
//		return getDao().update(object);
//	}
//	
//	public abstract GenericDao<T, K> getDao();
}
 