package com.dehrg.todos.model.jpa;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dehrg.todos.model.Task;
import com.dehrg.todos.model.TaskList;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "task")
public class TaskJPA implements Task {
	
	@Id
	@GeneratedValue
	@Column(name = "task_id")
	private Long id;
	
	@Column(name = "name", nullable = false, length = 150)
	private String name;
	
	@Column(name = "weight")
	private int weight;
	
	@Column(name = "complete")
	private boolean complete;
	
	@OneToMany(targetEntity = TaskJPA.class, mappedBy="parent")
	private Set<Task> subTasks = new HashSet<Task>(0);
	
	@ManyToOne(targetEntity = TaskJPA.class)
	@JoinColumn(name="parent_id")
	private Task parent;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "planned_finish_date")
	Calendar plannedFinishDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "actual_finish_date")
	Calendar actualFinishDate;
	
	@ManyToOne(targetEntity = TaskListJPA.class)
	@JoinColumn(name = "tasklist_id")
	TaskList taskList;
	
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
	public int getWeight() {
		return weight;
	}
	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public boolean isComplete() {
		return complete;
	}
	@Override
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	@JsonIgnore
	@Override
	public Set<Task> getSubTasks() {
		return subTasks;
	}
	@Override
	public void setSubTasks(Set<Task> subTasks) {
		this.subTasks = subTasks;
	}
	
	@Override
	public Task getParent() {
		return parent;
	}
	@Override
	public void setParent(Task parent) {
		this.parent = parent;
	}
	
	@Override
	public Calendar getPlannedFinishDate() {
		return plannedFinishDate;
	}
	@Override
	public void setPlannedFinishDate(Calendar date) {
		this.plannedFinishDate = date;
	}
	
	@Override
	public Calendar getActualFinishDate() {
		return actualFinishDate;
	}
	@Override
	public void setActualFinishDate(Calendar date) {
		this.actualFinishDate = date;
	}
	
	@Override
	public TaskList getTaskList() {
		return taskList;
	}
	@Override
	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}
	
}
