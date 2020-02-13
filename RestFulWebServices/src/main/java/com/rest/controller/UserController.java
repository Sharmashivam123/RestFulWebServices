package com.rest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.exception.OperationFailedException;
import com.rest.exception.PropertyNotSavedException;
import com.rest.exception.RequestProcessingFailedException;
import com.rest.exception.UserNotFoundException;
import com.rest.model.User;
import com.rest.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> userList = userService.getAllUser();
		if (userList == null || userList.isEmpty())
			throw new RequestProcessingFailedException("Your request Processing failed due to Bad Request.");
		return ResponseEntity.ok(userList);
	}

	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody @Valid User user, BindingResult result) {
		if (userService.save(user) == null) {
			throw new PropertyNotSavedException(user);
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable(required = false) int id) {
		User user = userService.getUser(id);
		if (user == null)
			throw new UserNotFoundException("User with the following id = " + id + " is not be found");
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable(required = false) int id) {
		boolean check = userService.deleteUser(id);
		if (check == false)
			throw new OperationFailedException("User with the following id = " + id + " can not be deleted.");
		return ResponseEntity.ok(check);
	}

}
