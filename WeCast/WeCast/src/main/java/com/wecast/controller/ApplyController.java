package com.wecast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wecast.exception.ServiceException;
import com.wecast.request.Apply;
import com.wecast.request.User;
import com.wecast.service.ApplyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ApplyController {

	@Autowired
	private ApplyService applyService;

	@PostMapping("/apply")
	public ResponseEntity<String> applyForJob(@RequestBody Apply apply) {
		Apply aply = null;
		try {
			aply = applyService.applyJob(apply);
		} catch (ServiceException e) {
			log.error(e.getMessage());
			return ResponseEntity.ok().body("You already aaplied for this job");
		}
		return ResponseEntity.ok().body("You aaplied successfully");

	}

	@GetMapping("/retrieveappliedby/{job_id}")
	public ResponseEntity<List<User>> retrieveAppliedBy(@PathVariable int job_id) {
		List<User> list = null;
		try {
			list = applyService.retrieveApplyBy(job_id);
		} catch (ServiceException e) {
			log.error(e.getMessage());
		}
		return ResponseEntity.ok().body(list);

	}

	@PutMapping("/selectstatus/{job_id}/{user_id}")
	public ResponseEntity<String> selectUserForProject(@PathVariable int job_id, @PathVariable int user_id) {
		Apply ap = applyService.selectUserForProject(job_id, user_id);
		if (ap != null) {
			return ResponseEntity.ok().body("Selected for project");
		}
		return null;

	}

	@GetMapping("/selectedusers/{job_id}")
	public ResponseEntity<List<User>> findSelectedUsers(@PathVariable int job_id) {
		List<User> userList;
		try {
			userList = applyService.findSelectedUsers(job_id);
			if (userList != null) {
				return ResponseEntity.ok().body(userList);
			}
		} catch (ServiceException e) {
			log.error(e.getMessage());
		}

		return null;

	}

}
