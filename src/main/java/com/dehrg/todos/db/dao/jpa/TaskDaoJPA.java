package com.dehrg.todos.db.dao.jpa;

import org.springframework.stereotype.Repository;

import com.dehrg.todos.db.dao.TaskDao;
import com.dehrg.todos.model.QTask;
import com.dehrg.todos.model.Task;
import com.mysema.query.types.path.EntityPathBase;

@Repository
public class TaskDaoJPA extends GenericJPADao<Task, Long> implements TaskDao {
	private QTask task = QTask.task;

	public TaskDaoJPA() {
		super(Task.class);
	}
	
	@Override
	public EntityPathBase<Task> getDefinition() {
		return task;
	}
}
