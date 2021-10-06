package com.wecast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public User addUser(@RequestBody User user) {
		User returnUser = userService.addUser(user);
		return returnUser;
	}

	@GetMapping("/finduserbyemailandpassword/{email}/{password}")
	public User findUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		User user = null;
		try {
			user = userService.findByEmailAndPassword(email, password);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return user;
	}

	@PutMapping("/updateuser/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
		try {
			return userService.updateUser(id, user);
		} catch (ServiceException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

	@GetMapping("/finduserbyid/{id}")
	public User findUserById(@PathVariable int id) {
		User user = userService.findById(id);
		return user;
	}

	@GetMapping("/findallusers")
	public List<User> getAllUsers() {
		List<User> users = null;
		try {
			users = userService.findAllUsers();
		} catch (ServiceException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return users;
	}

	@DeleteMapping("/deleteuserbyid/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteById(id);
		return "User deleted successfully";
	}

	@GetMapping("/getfriendsuggestion/{city}")
	public List<User> getSuggestions(@PathVariable String city) {
		List<User> suggestedList = userService.getFriendsSuggestion(city);
		return suggestedList;

	}

}
