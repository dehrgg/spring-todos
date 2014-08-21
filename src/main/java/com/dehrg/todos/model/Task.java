package com.dehrg.todos.model;

import java.util.Calendar;
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
	
	public Calendar getPlannedFinishDate();
	public void setPlannedFinishDate(Calendar date);
	
	public Calendar getActualFinishDate();
	public void setActualFinishDate(Calendar date);
	
	public Task getParent();
	public void setParent(Task parent);
	
	public TaskList getTaskList();
	public void setTaskList(TaskList taskList);

}