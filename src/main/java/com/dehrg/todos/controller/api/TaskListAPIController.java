package com.dehrg.todos.controller.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dehrg.todos.db.dao.GenericDao;
import com.dehrg.todos.db.dao.TaskListDao;
import com.dehrg.todos.model.TaskList;

@Controller
@RequestMapping(value="/tasklists")
public class TaskListAPIController extends APIController<TaskList, Long> {
	
	@Resource private TaskListDao dao;

	@Override
	protected GenericDao<TaskList, Long> getDao() {
		return dao;
	}
}
