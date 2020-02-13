package com.rest.exception;

import com.rest.model.User;

public class PropertyNotSavedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PropertyNotSavedException(User user) {
		super(user.getUsername() + " details cant be saved.");
	}
}
