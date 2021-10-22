package com.coopeuch.taskmanager.ws.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.coopeuch.taskmanager.ws.model.Task;
import com.coopeuch.taskmanager.ws.services.TaskService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE})
@RequestMapping("/api/task")
public class TaskController {
  
    @Autowired
    private TaskService taskService;
  
    @GetMapping("{id}")
    public ResponseEntity<Task> findById(@PathVariable final Long id) {
      return ResponseEntity.ok(taskService.findById(id));
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Task>> findAllProducts() {
      return ResponseEntity.ok(taskService.findAll());
    }
    
    @PostMapping("/add")
    public ResponseEntity<Task> save(@Valid @RequestBody(required = true) final Task task) {
      return ResponseEntity.ok(taskService.save(task));
    }
    
    @PatchMapping("/update")
    public ResponseEntity<Task> update(@Valid @RequestBody(required = true) final Task task) {
      return ResponseEntity.ok(taskService.save(task));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long id) {
      taskService.delete(id);
      return ResponseEntity.ok(id);
    }
	
}
