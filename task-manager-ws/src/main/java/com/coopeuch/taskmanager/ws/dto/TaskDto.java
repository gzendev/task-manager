package com.coopeuch.taskmanager.ws.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
	
	@NotNull
	private Long id;
	private String title;
	private String description;
	
}