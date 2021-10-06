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
import com.wecast.request.Project;
import com.wecast.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projService;

	@PostMapping("/addproject")
	public Project addProject(@RequestBody Project project) {
		Project pro = projService.addProject(project);
		return pro;

	}

	@GetMapping("/getprojects/{user_id}")
	public List<Project> getProjects(@PathVariable int user_id) {
		List<Project> projs = null;
		try {
			projs = projService.getProjects(user_id);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		return projs;
	}

	
	@PutMapping("/updateproject/{pid}")
	public Project updateProjectBypid(@PathVariable int pid, @RequestBody Project project) {
		//Project proj = null;
		Project retpro = null;
		try {
			retpro = projService.updateProject(pid, project);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		return retpro;

	}
	
	@DeleteMapping("/deleteprojectbyid/{pid}")
	public void deleteProject(@PathVariable int pid) {
		projService.deleteProject(pid);
	}
}
