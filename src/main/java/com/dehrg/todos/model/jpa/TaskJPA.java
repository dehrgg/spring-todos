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
	
	@OneToMany( cascade = CascadeType.ALL )
	@JoinTable( name = "task_parent", joinColumns = { @JoinColumn(name = "parent")}, 
		inverseJoinColumns = { @JoinColumn(name = "task_id") })
	private Set<TaskJPA> subTasks = new HashSet<TaskJPA>(0);
	
	/* (non-Javadoc)
	 * @see com.dehrg.todos.model.jpa.Task#getTaskId()
	 */
	
	public long getTaskId() {
		return taskId;
	}
	/* (non-Javadoc)
	 * @see com.dehrg.todos.model.jpa.Task#setTaskId(long)
	 */
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	
	/* (non-Javadoc)
	 * @see com.dehrg.todos.model.jpa.Task#getName()
	 */
	
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see com.dehrg.todos.model.jpa.Task#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see com.dehrg.todos.model.jpa.Task#getWeight()
	 */
	public int getWeight() {
		return weight;
	}
	/* (non-Javadoc)
	 * @see com.dehrg.todos.model.jpa.Task#setWeight(int)
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/* (non-Javadoc)
	 * @see com.dehrg.todos.model.jpa.Task#isComplete()
	 */
	public boolean isComplete() {
		return complete;
	}
	/* (non-Javadoc)
	 * @see com.dehrg.todos.model.jpa.Task#setComplete(boolean)
	 */
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	/* (non-Javadoc)
	 * @see com.dehrg.todos.model.jpa.Task#getSubTasks()
	 */
	public Set<TaskJPA> getSubTasks() {
		return subTasks;
	}
	/* (non-Javadoc)
	 * @see com.dehrg.todos.model.jpa.Task#setSubTasks(java.util.Set)
	 */
	public void setSubTasks(Set<TaskJPA> subTasks) {
		this.subTasks = subTasks;
	}
	
}
