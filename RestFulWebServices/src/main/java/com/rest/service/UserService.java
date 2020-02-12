package com.rest.service;

import java.util.List;

import com.rest.model.User;

public interface UserService {

	public List<User> getAllUser();

	public User save(User user);

	public User getUser(int id);

	public boolean deleteUser(int id);

}
