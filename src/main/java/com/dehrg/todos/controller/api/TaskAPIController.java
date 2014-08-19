package com.dehrg.todos.controller.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dehrg.todos.db.dao.TaskDao;
import com.dehrg.todos.model.Task;

@Controller
@RequestMapping(value = "/tasks")
public class TaskAPIController {
	
	@Resource private TaskDao dao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Task>> index() {
		List<Task> tasks = dao.readAll();
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Task> get(@PathVariable long id) {
		Task task = dao.read(id);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable long id) {
		dao.delete(id);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Task> create(@RequestBody Map<String, Object> updateValues) {
		Task task = dao.instanceOfPersistentClass();
		setProperties(task, updateValues);
		dao.create(task);
		return new ResponseEntity<Task>(task, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Task> update(@PathVariable long id, @RequestBody Map<String, Object> updateValues) {
		Task task = dao.read(id);
		setProperties(task, updateValues);
		task = dao.update(task);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
	private <T> void setProperties(T object, Map<String, Object> props) {
		BeanWrapper wrapper = new BeanWrapperImpl(object);
		wrapper.setPropertyValues(props);
	}
	
}
