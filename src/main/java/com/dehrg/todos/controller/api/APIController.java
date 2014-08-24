package com.dehrg.todos.controller.api;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dehrg.todos.db.dao.GenericDao;
import com.dehrg.todos.model.PersistentEntity;

public abstract class APIController<T extends PersistentEntity<K>, K extends Serializable> {
	protected <O> void setProperties(O object, Map<String, Object> props) {
		BeanWrapper wrapper = new BeanWrapperImpl(object);
		wrapper.setPropertyValues(props);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<T>> index() {
		List<T> lists = getDao().readAll();
		return new ResponseEntity<List<T>>(lists, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<T> get(@PathVariable K id) {
		T list = getDao().read(id);
		return new ResponseEntity<T>(list, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable K id) {
		getDao().delete(id);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<T> create(@RequestBody Map<String, Object> updateValues) {
		T list = getDao().instanceOfPersistentClass();
		setProperties(list, updateValues);
		getDao().create(list);
		return new ResponseEntity<T>(list, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<T> update(@PathVariable K id, @RequestBody Map<String, Object> updateValues) {
		T list = getDao().read(id);
		setProperties(list, updateValues);
		list = getDao().update(list);
		return new ResponseEntity<T>(list, HttpStatus.OK);
	}
	
	protected abstract GenericDao<T, K> getDao();
}
