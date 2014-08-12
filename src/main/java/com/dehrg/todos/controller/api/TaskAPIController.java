package com.dehrg.todos.controller.api;

import java.util.List;

import javax.annotation.Resource;

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
	public ResponseEntity<List<? extends Task>> index() {
		List<? extends Task> tasks = dao.readAll();
		return new ResponseEntity<List<? extends Task>>(tasks, HttpStatus.OK);
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
	public ResponseEntity<Task> create(@RequestBody Task object) {
		Task task = dao.create(object);
		return new ResponseEntity<Task>(task, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Task> update(@PathVariable long id, @RequestBody Task object) {
		object.setTaskId(id);
		Task task = dao.update(object);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
}
