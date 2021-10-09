package com.wecast.service;

import java.util.List;

import com.wecast.exception.ServiceException;
import com.wecast.request.Apply;
import com.wecast.request.Job;

public interface JobService {
	
	public Job createJob(Job job);

	
	public Job getById(int job_id) throws ServiceException;
	

}
