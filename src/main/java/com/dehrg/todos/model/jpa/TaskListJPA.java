package com.dehrg.todos.model.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dehrg.todos.model.Task;
import com.dehrg.todos.model.TaskList;

@Entity
@Table( name = "tasklist" )
public class TaskListJPA implements TaskList {
	
	@Id
	@GeneratedValue
	@Column(name = "tasklist_id")
	private Long id;
	
	@Column(name = "name", nullable = false, length = 150)
	private String name;
	
	@OneToMany( targetEntity = TaskJPA.class, fetch = FetchType.EAGER, mappedBy = "taskList"  )
	private Set<Task> tasks = new HashSet<Task>();

	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long taskId) {
		this.id = taskId;
	}
	
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
