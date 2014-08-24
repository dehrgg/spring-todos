package com.dehrg.todos.db.dao.jpa;

import org.springframework.stereotype.Repository;

import com.dehrg.todos.db.dao.TaskListDao;
import com.dehrg.todos.model.TaskList;
import com.dehrg.todos.model.jpa.QTaskListJPA;
import com.dehrg.todos.model.jpa.TaskListJPA;
import com.mysema.query.types.path.EntityPathBase;

@Repository
public class TaskListDaoJPA extends GenericJPADao<TaskList, Long> implements TaskListDao {
	
	private final QTaskListJPA TASKLIST = QTaskListJPA.taskListJPA;
	
	public TaskListDaoJPA() {
		super(TaskListJPA.class);
	}

	@Override
	protected EntityPathBase<? extends TaskList> getDefinition() {
		return TASKLIST;
	}

}
