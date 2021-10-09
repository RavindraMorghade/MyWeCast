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

@RestController
public class ApplyController {
	
	@Autowired
	private ApplyService applyService;
	
	@PostMapping("/apply")
	public ResponseEntity<Apply> applyForJob(@RequestBody Apply apply) {
		Apply aply = applyService.applyJob(apply);
		return ResponseEntity.ok().body(aply);
		
	}
	
	@GetMapping("/retrieveappliedby/{job_id}")
	public  ResponseEntity<List<User>> retrieveAppliedBy(@PathVariable int job_id){
		List<User> list=null;
		try {
			 list = applyService.retrieveApplyBy(job_id);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok().body(list);
		
	}
	
	@PutMapping("/selectstatus/{job_id}/{user_id}")
	public ResponseEntity<String> selectUserForProject(@PathVariable int job_id, @PathVariable int user_id) {
		Apply ap = applyService.selectUserForProject(job_id, user_id);
		if(ap != null) {
		return ResponseEntity.ok().body("Selected for project");
		}
		return null;
		
	}
	
	@GetMapping("/selectedusers/{job_id}")
	public ResponseEntity<List<Apply>> findSelectedUsers(@PathVariable int job_id){
		List<Apply> al = applyService.findSelectedUsers(job_id);
		if(al!=null) {
			return ResponseEntity.ok().body(al);
		}
		return null;
		
	}

}
