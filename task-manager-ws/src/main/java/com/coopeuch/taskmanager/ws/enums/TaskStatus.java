package com.coopeuch.taskmanager.ws.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

public @Getter @AllArgsConstructor(access = AccessLevel.PRIVATE) enum TaskStatus {
  
  NEW(0, "Nuevo"),
  PROCESSED(1, "Parcialmente Completado"), 
  FAILED(2, "No Completada"), 
  READY(3, "Completada");

  private Integer id;
  private String name;

  public static TaskStatus getTaskStatus(final Integer id) {
    if (id != null) {
      final List<TaskStatus> values = Arrays.stream(TaskStatus.values()).collect(Collectors.toList());
      for (final TaskStatus taskStatus : values) {
        if (id.equals(taskStatus.getId())) {
          return taskStatus;
        }
      }
    }
    return null;
  }
}