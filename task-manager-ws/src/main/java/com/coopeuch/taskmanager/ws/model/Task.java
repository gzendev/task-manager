package com.coopeuch.taskmanager.ws.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.coopeuch.taskmanager.ws.dto.TaskDto;
import com.coopeuch.taskmanager.ws.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name="Task", schema = "CC")
public class Task implements Serializable {

	private static final long serialVersionUID = 4794047030567907737L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id", unique = true, nullable = false)
	private Long id;
	
	@NotEmpty
	@NotNull
    @Column(name = "title", updatable = true, nullable = false)
    private String title;
	
	@Enumerated
    @Column(columnDefinition = "smallint")
    private TaskStatus status;
	
	@NotEmpty
	@NotNull
	@Column(name = "description", updatable = true, nullable = false)
	private String description;
	
    @Column(name = "creation_date", updatable = false, nullable = false)
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime creationDate;
    
    @PrePersist
    public void prePersist() {
      creationDate = LocalDateTime.now();
    }
		
	public static TaskDto fromModel(final Task task) {
		return new TaskDto(task.getId(), task.getTitle(), task.getDescription());		
	}
	
}
