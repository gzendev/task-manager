package com.coopeuch.taskmanager.ws.services;

import java.util.List;
import com.coopeuch.taskmanager.ws.model.Task;

public interface TaskService {
	
	public Task findById(final Long id);
	
	public List<Task> findAll();
	
	public Task save(final Task model);
	
	public void delete(final Long id);
	
}
