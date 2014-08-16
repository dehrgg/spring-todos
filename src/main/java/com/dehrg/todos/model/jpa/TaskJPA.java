package com.dehrg.todos.model.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.dehrg.todos.model.Task;

@Entity
@Table(name = "task")
public class TaskJPA implements Task {
	
	@Id
	@GeneratedValue
	@Column(name = "task_id")
	private long taskId;
	
	@Column(name = "name", nullable = false, length = 150)
	private String name;
	
	@Column(name = "weight")
	private int weight;
	
	@Column(name ="complete")
	private boolean complete;
	
	@OneToMany( cascade = CascadeType.ALL, targetEntity=TaskJPA.class )
	@JoinTable( name = "task_parent", joinColumns = { @JoinColumn(name = "parent")}, 
		inverseJoinColumns = { @JoinColumn(name = "task_id") })
	private Set<Task> subTasks = new HashSet<Task>(0);
	
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	@JsonIgnore
	public Set<Task> getSubTasks() {
		return subTasks;
	}
	public void setSubTasks(Set<Task> subTasks) {
		this.subTasks = subTasks;
	}
	
}
