package com.dehrg.todos.db.dao.jpa;

import org.springframework.stereotype.Repository;

import com.dehrg.todos.db.dao.TaskDao;
import com.dehrg.todos.model.Task;
import com.dehrg.todos.model.jpa.QTaskJPA;
import com.mysema.query.types.path.EntityPathBase;

@Repository
public class TaskDaoJPA extends GenericJPADao<Task, Long> implements TaskDao {
	private QTaskJPA task = QTaskJPA.taskJPA;

	@Override
	public EntityPathBase<? extends Task> getDefinition() {
		return task;
	}
}
