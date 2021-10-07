package com.wecast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wecast.exception.ServiceException;
import com.wecast.request.User;
import com.wecast.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User returnUser = userService.addUser(user);
		return ResponseEntity.ok().body(returnUser);
	}

	@GetMapping("/finduserbyemailandpassword/{email}/{password}")
	public ResponseEntity<User> findUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		User user = null;
		try {
			user = userService.findByEmailAndPassword(email, password);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
		User retUser = null;
		try {
			retUser = userService.updateUser(id, user);
		} catch (ServiceException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
			return ResponseEntity.ok().body(e.getMessage());
		}
		return ResponseEntity.ok().body("User successfully updated");
	}

	@GetMapping("/finduserbyid/{id}")
	public ResponseEntity<User> findUserById(@PathVariable int id) {
		User user = null;
		try {
			user = userService.findById(id);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/findallusers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = null;
		try {
			users = userService.findAllUsers();
		} catch (ServiceException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return ResponseEntity.ok().body(users);
	}

	@DeleteMapping("/deleteuserbyid/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		userService.deleteById(id);
		return ResponseEntity.ok().body("User deleted successfully");
	}

	@GetMapping("/getfriendsuggestion/{city}")
	public ResponseEntity<List<User>> getSuggestions(@PathVariable String city) {
		List<User> suggestedList = userService.getFriendsSuggestion(city);
		return ResponseEntity.ok().body(suggestedList);

	}

}
