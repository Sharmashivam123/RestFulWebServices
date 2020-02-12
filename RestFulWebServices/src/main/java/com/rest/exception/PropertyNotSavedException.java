package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rest.model.User;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class PropertyNotSavedException extends RuntimeException {

	public PropertyNotSavedException(User user) {
		super(user.getUsername() + " details cant be saved.");
	}

	private static final long serialVersionUID = 1L;

}
