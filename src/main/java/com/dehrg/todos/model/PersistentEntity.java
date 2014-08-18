package com.dehrg.todos.model;

import java.io.Serializable;

public interface PersistentEntity <K extends Serializable> {

	public K getId();

	public void setId(K taskId);
}
