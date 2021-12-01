package com.wecast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProjectController {

	@Autowired
	private ProjectService projService;

	@PostMapping("/addproject")
	public ResponseEntity<Project>addProject(@RequestBody Project project) {
		Project pro = projService.addProject(project);
		return ResponseEntity.ok().body(pro);

	}

	@GetMapping("/getprojects/{user_id}")
	public ResponseEntity<List<Project>> getProjects(@PathVariable int user_id) {
		List<Project> projs = null;
		try {
			projs = projService.getProjects(user_id);
		} catch (ServiceException e) {
			log.error(e.getMessage());
		}
		return ResponseEntity.ok().body(projs);
	}

	
	@PutMapping("/updateproject/{pid}")
	public ResponseEntity<Project> updateProjectBypid(@PathVariable int pid, @RequestBody Project project) {
		//Project proj = null;
		Project retpro = null;
		try {
			retpro = projService.updateProject(pid, project);
		} catch (ServiceException e) {
			log.error(e.getMessage());
		}
		return ResponseEntity.ok().body(retpro);

	}
	
	@DeleteMapping("/deleteprojectbyid/{pid}")
	public ResponseEntity<String> deleteProject(@PathVariable int pid) {
		projService.deleteProject(pid);
		return ResponseEntity.ok().body("Project deleted successfully");
	}
}
