package com.dehrg.todos.controller.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dehrg.todos.db.dao.GenericDao;
import com.dehrg.todos.db.dao.TaskDao;
import com.dehrg.todos.model.Task;

@Controller
@RequestMapping(value = "/tasks")
public class TaskAPIController extends APIController<Task, Long> {
	
	@Resource private TaskDao dao;

	@Override
	protected GenericDao<Task, Long> getDao() {
		return dao;
	}
	
}
