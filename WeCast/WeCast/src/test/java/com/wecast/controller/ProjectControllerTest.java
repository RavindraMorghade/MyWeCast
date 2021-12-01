package com.wecast.controller;

import static org.junit.jupiter.api.Assertions.*;
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
import com.wecast.repo.ProjectRepository;
import com.wecast.repo.UserRepository;
import com.wecast.request.Project;
import com.wecast.request.User;
import com.wecast.request.UserRequest;
import com.wecast.service.ProjectService;
import com.wecast.service.UserService;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ProjectControllerTest {
	
	@InjectMocks
	private ProjectController controller;

	@Mock
	private ProjectService service;

	private Project project;
	private List<User> userList = new ArrayList<User>();
	private UserRequest userRequest;
	private List<Project> projectList = new ArrayList<>();

	private ProjectRepository repository;

	@Before
	public void setup() throws Exception {
		project = Project.builder().pid(2).desc("Testing").name("Fedex").createdBy(1).build();
		projectList.add(project);
	}

	@Test
	public void addProjectTest() {
		when(service.addProject(project)).thenReturn(project);
		ResponseEntity<Project> responseEntity = controller.addProject(project);
		assertEquals(HttpStatus.OK	, responseEntity.getStatusCode());
	}
	@Test
	public void getProjectsTest() throws ServiceException {
		when(service.getProjects(10)).thenReturn(projectList);
		ResponseEntity<List<Project>> responseEntity = controller.getProjects(10);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void getProjectsTestFailure() throws ServiceException {
		when(service.getProjects(10)).thenThrow(new ServiceException(""));
		ResponseEntity<List<Project>> responseEntity = controller.getProjects(10);
		Assert.assertNull(responseEntity.getBody());
	}
	@Test
	public void updateProjectBypidTest() throws ServiceException {
		when(service.updateProject(1, project)).thenReturn(project);
		ResponseEntity<Project> responseEntity = controller.updateProjectBypid(1, project);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void updateProjectBypidTestFailure() throws ServiceException {
		when(service.updateProject(1, project)).thenThrow(new ServiceException(""));
		ResponseEntity<Project> responseEntity = controller.updateProjectBypid(1, project);
		Assert.assertNull(responseEntity.getBody());
	}
	@Test 
	public void deleteProjectTest() {
		ResponseEntity<String> responseEntity = controller.deleteProject(1);
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
	}

}
