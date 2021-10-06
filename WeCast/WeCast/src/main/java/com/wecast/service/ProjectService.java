package com.wecast.service;

import java.util.List;

import com.wecast.exception.ServiceException;
import com.wecast.request.Project;

public interface ProjectService{
	
	public Project addProject(Project pro);
	
	List<Project> getProjects(int user_id) throws ServiceException;
	
	 public Project updateProject(int pid, Project project) throws ServiceException;

	public void deleteProject(int pid);
	 


}
