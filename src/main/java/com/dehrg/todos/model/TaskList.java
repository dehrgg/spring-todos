package com.dehrg.todos.model;

import java.util.Set;

public interface TaskList {
	public String getName();
	public void setName(String name);
	
	public Set<Task> getTasks();
	public void setTasks(Set<Task> tasks);
}
