package com.wecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wecast.request.Profile;
import com.wecast.service.ProfileService;

@RestController
public class ProfileLikeCommentController {
	
	@Autowired
	private ProfileService profileService;
	
	@PutMapping("/like")
	public ResponseEntity<String> likeBy(@RequestBody Profile profile) {
		//profile.getId()
		String retprofile = profileService.likedBy(profile.getId(), profile.getLikeBy());
		return ResponseEntity.ok().body(retprofile);
		
	}
	
	@PutMapping("/comment")
	public ResponseEntity<String> commentedBy(@RequestBody Profile profile) {
		String retprofile = profileService.commentBy(profile.getId(), profile.getCommentBy(), profile.getTextComments());
		return ResponseEntity.ok().body(retprofile);
		
	}

}
