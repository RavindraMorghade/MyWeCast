package com.wecast.contoller;

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
import com.wecast.exception.ServiceException;
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
	public void setup() throws Exception {
		userRequestsList = new ArrayList<UserRequest>();
		user = User.builder().id(1).name("Neha").lastName("Mahajan").dob("08/04/1996").email("nehamahajan@gmail.com").build();
		userList.add(user);

	}

	@Test
	public void addUserTest() {
		when(service.addUser(user)).thenReturn(user);
		ResponseEntity<User> responseEntity = controller.addUser(user);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	}

	@Test
	public void addUserFailureTestThrowsException() {
		ResponseEntity<User> responseEntity = controller.addUser(null);
		Assert.assertNull(responseEntity.getBody());
	}

	@Test
	public void findUserByEmailAndPasswordTest() throws ServiceException {
		when(service.findByEmailAndPassword("neha@gmail", "123")).thenReturn(user);
		ResponseEntity<User> responseEntity = controller.findUserByEmailAndPassword("neha@gmail", "123");
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void findUserByEmailAndPasswordTestFailure() throws ServiceException {
		when(service.findByEmailAndPassword("neha@gmail", "123")).thenThrow(new ServiceException(""));
		ResponseEntity<User> responseEntity = controller.findUserByEmailAndPassword("neha@gmail", "123");
		Assert.assertNull(responseEntity.getBody());
	}

	@Test
	public void findUserByIdTest() throws ServiceException {
		when(service.findById(2)).thenReturn(user);
		ResponseEntity<User> responseEntity = controller.findUserById(2);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void findUserByIdTestFailure() throws ServiceException {
		when(service.findById(2)).thenThrow(new ServiceException(""));
		ResponseEntity<User> responseEntity = controller.findUserById(2);
		Assert.assertNull(responseEntity.getBody());
	}

	@Test
	public void getAllUsers() throws ServiceException {
		when(service.findAllUsers()).thenReturn(userList);
		ResponseEntity<List<User>> responseEntity = controller.getAllUsers();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getAllUsersFailure() throws ServiceException {
		when(service.findAllUsers()).thenThrow(new ServiceException(""));
		ResponseEntity<List<User>> responseEntity = controller.getAllUsers();
		Assert.assertNull(responseEntity.getBody());
	}

	@Test
	public void deleteUserTest() {
		ResponseEntity<String> responseEntity = controller.deleteUser(2);
		Assert.assertNotNull(responseEntity);
	}

	@Test
	public void getSuggestionsTest() {
		when(service.getFriendsSuggestion("Pune")).thenReturn(userList);
		ResponseEntity<List<User>> responseEntity = controller.getSuggestions("Pune");
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	}
}
