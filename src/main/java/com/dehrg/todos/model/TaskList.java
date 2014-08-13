package com.dehrg.todos.model;
//package com.dehrg.todos.model.jpa;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.*;
//
//@Entity
//@Table( name = "tasklist" )
//public class TaskList {
//	
//	@OneToMany( cascade = CascadeType.ALL )
//	@JoinTable( name = "task_tasklist", joinColumns = { @JoinColumn(name = "task_id")}, 
//	inverseJoinColumns = { @JoinColumn(name = "task_id") })
//	private Set<TaskJPAImpl> tasks = new HashSet<TaskJPAImpl>();
//}
