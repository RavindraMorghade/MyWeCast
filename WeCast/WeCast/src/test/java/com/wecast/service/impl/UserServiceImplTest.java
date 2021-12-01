package com.wecast.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.wecast.repo.UserRepository;
import com.wecast.request.User;
import com.wecast.request.UserRequest;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class UserServiceImplTest {

	@InjectMocks
	private UserServiceImpl service;

	@Mock
	private UserRepository repository;

	private User user;
	private UserRequest userRequest;
	private List<UserRequest> userRequestsList;
	private List<User> userList = new ArrayList<User>();

	@Before
	public void setup() {
		userRequestsList = new ArrayList<UserRequest>();
		user = User.builder().id(1).name("Neha").lastName("Mahajan").dob("08/04/1996").email("nehamahajan@gmail.com").password("123").build();
		userList.add(user);
	}
	
	@Test
	public void addUserTest() {
		user = User.builder().id(1).name("Neha").lastName("Mahajan").dob("08/04/1996").email("nehamahajan@gmail.com").password("123").build();
		when(repository.save(user)).thenReturn(user);
		User retuser = service.addUser(user);
		assertEquals(1, retuser.getId());
	}
	
	

}
