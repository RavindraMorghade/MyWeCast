package com.wecast.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wecast.exception.ServiceException;
import com.wecast.repo.ApplyRepository;
import com.wecast.request.Apply;
import com.wecast.request.User;
import com.wecast.service.impl.ApplyServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ApplyControllerTest {

	@InjectMocks
	private ApplyController controller;

	@Mock
	private ApplyServiceImpl service;

	@Mock
	private Apply apply;
	
	private User user;
	private List<User> userList = new ArrayList<>();
	private List<Apply> applyList = new ArrayList<Apply>();
	private Apply applyRequest;

	private ApplyRepository repository;

	@Before
	public void setup() throws Exception {
	//	applyRequestsList = new ArrayList<Apply>();
		apply = Apply.builder().aId(1).userId(10).jobId(2).status("Selected").build();
		applyList.add(apply);
		user = User.builder().id(1).name("Ravi").lastName("Mahajan").build();
		userList.add(user);
	}

	@Test
	public void applyForJobTest() throws ServiceException {
		when(service.applyJob(apply)).thenReturn(apply);
		ResponseEntity<String> responseEntity = controller.applyForJob(apply);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	  @Test
	  public void applyForJobTestFailure() throws ServiceException {
	  when(service.applyJob(apply)).thenThrow(new ServiceException("You already aaplied for this job"));
	  ResponseEntity<String> responseEntity = controller.applyForJob(apply);
	  Assert.assertNotNull(responseEntity.getBody());
	  }
	 
	@Test
	public void retrieveAppliedBy() throws ServiceException {
	when(service.retrieveApplyBy(1)).thenReturn(userList);
	ResponseEntity<List<User>> responseEntity = controller.retrieveAppliedBy(1);
	assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void retrieveAppliedByFailure() throws ServiceException {
	when(service.retrieveApplyBy(1)).thenThrow(new ServiceException(""));
	ResponseEntity<List<User>> responseEntity = controller.retrieveAppliedBy(1);
	Assert.assertNull(responseEntity.getBody());
	}
	
	@Test
	public void selectUserForProject() throws ServiceException {
		when(service.findSelectedUsers(1)).thenReturn(userList);
		ResponseEntity<List<User>> responseEntity = controller.findSelectedUsers(1);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void selectUserForProjectFailure() throws ServiceException {
		when(service.findSelectedUsers(1)).thenThrow(new ServiceException(""));
		ResponseEntity<List<User>> responseEntity = controller.findSelectedUsers(1);
		Assert.assertNull(responseEntity);
	}
	

}
