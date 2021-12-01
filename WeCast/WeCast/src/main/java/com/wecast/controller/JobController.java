package com.wecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wecast.exception.ServiceException;
import com.wecast.request.Job;
import com.wecast.service.JobService;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Builder
public class JobController {

	@Autowired
	private JobService jobService;

	@PostMapping("/createjob")
	public ResponseEntity<Job> createJob(@RequestBody Job job) {
		Job retJob = jobService.createJob(job);
		return ResponseEntity.ok().body(retJob);

	}

	@GetMapping("/getjobbyid/{id}")
	public ResponseEntity<Job> findJobById(@PathVariable int id) {
		Job jb = null;
		try {
			jb = jobService.getById(id);
		} catch (ServiceException e) {
			log.error(e.getMessage());
		}
		return ResponseEntity.ok().body(jb);

	}

}
