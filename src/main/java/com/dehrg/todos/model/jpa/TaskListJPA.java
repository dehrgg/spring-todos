package com.dehrg.todos.model.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dehrg.todos.model.Task;
import com.dehrg.todos.model.TaskList;

@Entity
@Table( name = "tasklist" )
public class TaskListJPA implements TaskList {
	
	@Column(name = "name", nullable = false, length = 150)
	private String name;
	
	@OneToMany( cascade = CascadeType.ALL, targetEntity = TaskJPA.class, fetch = FetchType.EAGER  )
	@JoinTable( name = "task_tasklist", joinColumns = { @JoinColumn(name = "task_id")}, 
	inverseJoinColumns = { @JoinColumn(name = "task_id") })
	private Set<Task> tasks = new HashSet<Task>();

	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Set<Task> getTasks() {
		return this.tasks;
	}
	@Override
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;		
	}
}
