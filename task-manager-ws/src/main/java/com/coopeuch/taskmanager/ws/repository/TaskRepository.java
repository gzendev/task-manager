package com.coopeuch.taskmanager.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coopeuch.taskmanager.ws.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
