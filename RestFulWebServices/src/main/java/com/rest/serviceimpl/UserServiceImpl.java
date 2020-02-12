package com.rest.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.model.User;
import com.rest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> getAllUser() {
		return null;
	}

	@Override
	public User save(User user) {
		return null;
	}

	@Override
	public User getUser(int id) {
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		return false;

	}

}
