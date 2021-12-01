package com.wecast;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wecast.controller.UserController;
import com.wecast.repo.UserRepository;
import com.wecast.request.User;
import com.wecast.request.UserRequest;
import com.wecast.service.UserService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	@InjectMocks
	private UserController controller;
	
	@Mock
	private UserService service;
	
	private User user;
	private List<UserRequest> userRequestsList;
	private List<User> userList = new ArrayList<User>();
	private UserRequest userRequest;
	
	private UserRepository repository;
	
	@Before
	public void setup() throws Exception{
		userRequestsList = new ArrayList<UserRequest>();
		user = User.builder().id(1).name("Neha").lastName("Mahajan").dob("08/04/1996").email("nehamahajan@gmail.com").build();
		userList.add(user);
		
	}
	
	@Test
	public void addUserTest() {
		when(service.addUser((User) any(User.class))).thenReturn(user);
		ResponseEntity<User> responseEntity = controller.addUser(user);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
	}
	
	@Test
	public void addUserFailureTestThrowsException() {
		ResponseEntity<User> responseEntity = controller.addUser(null);
		Assert.assertNull(responseEntity.getBody());
	}
	

}
