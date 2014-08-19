package com.dehrg.todos.model;

import java.util.Set;

import com.dehrg.todos.Actionable;

public interface Task extends Actionable, PersistentEntity<Long> {

	public String getName();

	public void setName(String name);

	public int getWeight();

	public void setWeight(int weight);

	public boolean isComplete();

	public void setComplete(boolean complete);

	public Set<Task> getSubTasks();

	public void setSubTasks(Set<Task> subTasks);

}