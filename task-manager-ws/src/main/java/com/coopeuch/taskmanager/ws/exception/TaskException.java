package com.coopeuch.taskmanager.ws.exception;

import com.coopeuch.taskmanager.ws.message.Messages;

public final class TaskException extends RuntimeException {

	private static final long serialVersionUID = 2070058637450167250L;
	
	private final String message;
	
	public TaskException(String message) {
		this.message = message;
	}
	
	public static TaskException notFound() {
		return new TaskException(Messages.ID_NOT_FOUND);
	}
	
	public String getMessage() {
		return message;
	}
}
