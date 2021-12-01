package com.wecast.contoller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wecast.controller.ApplyController;
import com.wecast.exception.ServiceException;
import com.wecast.repo.ApplyRepository;
import com.wecast.request.Apply;
import com.wecast.service.ApplyService;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class ApplyControllerTest {

	@InjectMocks
	private ApplyController controller;

	@Mock
	private ApplyService service;

	private Apply apply;
	private List<Apply> applyRequestsList;
	private List<Apply> applyList = new ArrayList<Apply>();
	private Apply applyRequest;

	private ApplyRepository repository;

	@Before
	public void setup() throws Exception {
		applyRequestsList = new ArrayList<Apply>();
		apply = Apply.builder().aId(1).userId(10).jobId(2).status("Selected").build();
		applyList.add(apply);

	}

	@Test
	public void applyForJobTest() throws ServiceException {
		when(service.applyJob(apply)).thenReturn(apply);
		ResponseEntity<String> responseEntity = controller.applyForJob(apply);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	/*
	 * @Test public void applyForJobTestFailure() throws ServiceException {
	 * when(service.applyJob(apply)).thenThrow(new ServiceException(""));
	 * ResponseEntity<String> responseEntity = controller.applyForJob(apply);
	 * Assert.assertNull(responseEntity.getBody()); }
	 */
	public void retrieveAppliedBy() {
	//	when(service.)
	}

}
