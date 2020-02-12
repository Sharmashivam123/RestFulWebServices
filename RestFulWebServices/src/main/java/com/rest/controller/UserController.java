package com.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.exception.PropertyNotSavedException;
import com.rest.model.User;
import com.rest.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok(userService.getAllUser());
	}

	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		if (userService.save(user) == null) {
			throw new PropertyNotSavedException(user);
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable(required = false) int id) {
		return ResponseEntity.ok(userService.getUser(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable(required = false) int id) {
		return ResponseEntity.ok(userService.deleteUser(id));
	}

}
