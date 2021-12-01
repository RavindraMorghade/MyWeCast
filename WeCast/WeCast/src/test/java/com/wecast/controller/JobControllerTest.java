package com.wecast.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wecast.exception.ServiceException;
import com.wecast.repo.JobRepository;
import com.wecast.request.Job;
import com.wecast.service.JobService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class JobControllerTest {
	@InjectMocks
	private JobController controller;
	
	@Mock
	private JobService service;
	
	private JobRepository repository;
	@Mock
	private Job job;
	
	@Test
	public void createJobTest() {
		when(service.createJob(job)).thenReturn(job);
		ResponseEntity<Job> responseEntity = controller.createJob(job);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void findJobByIdTest() throws ServiceException {
		when(service.getById(1)).thenReturn(job);
		ResponseEntity<Job> responseEntity = controller.findJobById(1);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void findJobByIdTestFailure() throws ServiceException {
		when(service.getById(1)).thenThrow(new ServiceException(""));
		ResponseEntity<Job> responseEntity = controller.findJobById(1);
		Assert.assertNull(responseEntity.getBody());
	}

}
