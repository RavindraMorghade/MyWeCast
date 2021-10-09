package com.wecast.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.wecast.exception.ServiceException;
import com.wecast.repo.JobRepository;
import com.wecast.request.Apply;
import com.wecast.request.Job;
import com.wecast.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;
	
	

	@Override
	public Job createJob(Job job) {
		Job jb = jobRepository.save(job);
		return job;
	}

	@Override
	public Job getById(int job_id) throws ServiceException {
		Optional<Job> job = jobRepository.findById(job_id);
		if (job.isPresent()) {
			return job.get();
		} else {
			throw new ServiceException("Job not found for such job_id");
		}

	}

	

}
