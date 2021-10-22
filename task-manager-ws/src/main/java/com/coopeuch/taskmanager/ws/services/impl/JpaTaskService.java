package com.coopeuch.taskmanager.ws.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coopeuch.taskmanager.ws.exception.TaskException;
import com.coopeuch.taskmanager.ws.exception.ResourceNotFoundException;
import com.coopeuch.taskmanager.ws.model.Task;
import com.coopeuch.taskmanager.ws.repository.TaskRepository;
import com.coopeuch.taskmanager.ws.services.TaskService;

@Service
public class JpaTaskService implements TaskService {
	
	@Autowired
	private TaskRepository taskRespository;
	
	
	@Override
	public Task findById(final Long id) {
		return taskRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found task with id = " + id));
	}
	
	@Override
    public List<Task> findAll() {
        return taskRespository.findAll();
    }
	
	public Task save(final Task model) {
      Task task = taskRespository.save(model);
      if(task == null)
          throw new TaskException("Error Processing for " + model.getId());
      return task;
    }
	
	@Override
    public void delete(Long id) {
	  taskRespository.deleteById(id);
    }

}
