package com.dehrg.todos.model;

import java.util.Set;

import com.dehrg.todos.Actionable;
import com.dehrg.todos.model.jpa.TaskJPA;

public interface Task extends Actionable {

	public long getTaskId();

	public void setTaskId(long taskId);

	public String getName();

	public void setName(String name);

	public int getWeight();

	public void setWeight(int weight);

	public boolean isComplete();

	public void setComplete(boolean complete);

	public Set<TaskJPA> getSubTasks();

	public void setSubTasks(Set<TaskJPA> subTasks);

}