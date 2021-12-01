package com.wecast.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecast.exception.ServiceException;
import com.wecast.repo.ProjectRepository;
import com.wecast.request.Project;
import com.wecast.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projReposotory;

	public Project addProject(Project pro) {
		Project proj = projReposotory.save(pro);
		return proj;
	}

	@Override
	public List<Project> getProjects(int user_id) throws ServiceException {
		List<Project> projects = projReposotory.getProjects(user_id);
		if (projects.isEmpty()) {
			throw new ServiceException("Projects record not present");
		}
		return projects;

	}

	@Override
	public Project updateProject(int pid, Project project) throws ServiceException {
		Optional<Project> proj = projReposotory.findByPid(pid);
		Project pro = null;
		Project retpro = null;
		if (proj.isPresent()) {
			pro = proj.get();
			pro.setName(project.getName());
			pro.setDesc(project.getDesc());
			pro.setCreatedBy(project.getCreatedBy());
			 retpro = projReposotory.save(pro);
		} else {
			throw new ServiceException("Project not found for given pid");
		}
		return retpro;
	}
	
	public String deleteProject(int pid) {
		projReposotory.deleteById(pid);
		return ("Project deleted successfully");
	}

}
