package com.wecast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wecast.exception.ServiceException;
import com.wecast.request.LikeAndComment;
import com.wecast.request.User;
import com.wecast.service.LikeAndCommentService;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Builder
public class LikeAndCommentController {

	@Autowired
	private LikeAndCommentService likeAndCommentService;

	@PostMapping("/likes")
	public ResponseEntity<LikeAndComment> likedBy(@RequestBody LikeAndComment request) {
		LikeAndComment likeAndComment = likeAndCommentService.likeBy(request.getLikedById(), request.getProfileId());
		return ResponseEntity.ok().body(likeAndComment);

	}

	@PostMapping("/comments")
	public LikeAndComment commentedBy(@RequestBody LikeAndComment request) {
		LikeAndComment likeAndComment = likeAndCommentService.commentBy(request.getCommentById(),
				request.getProfileId(), request.getTextComments());
		return likeAndComment;

	}

	/*
	 * @GetMapping("/findlikesonprofile/{profile_id}") public List<LikeAndComment>
	 * retriveLikesOnProfile(@PathVariable Integer profile_id){ List<LikeAndComment>
	 * likeAndComment =likeAndCommentService.findLikesOnProfile(profile_id); return
	 * likeAndComment;
	 * 
	 * }
	 */

	@GetMapping("/findlikesonprofile/{profile_id}")
	public ResponseEntity<List<User>> findLikesonprofile(@PathVariable Integer profile_id) {
		List<User> list = null;
		try {
			list = likeAndCommentService.findLikesOnProfile(profile_id);
		} catch (ServiceException e) {
			log.error(e.getMessage());
		}
		return ResponseEntity.ok().body(list);

	}

	@GetMapping("/findcommentsonprofile/{profile_id}")
	public ResponseEntity<List<User>> findCommentsOnProfile(@PathVariable Integer profile_id) {
		List<User> list = null;
		try {
			list = likeAndCommentService.findCommentsOnProfile(profile_id);
		} catch (ServiceException e) {
			log.error(e.getMessage());
		}
		return ResponseEntity.ok().body(list);

	}

}
