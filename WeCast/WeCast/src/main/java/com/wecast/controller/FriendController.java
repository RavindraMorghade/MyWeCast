package com.wecast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wecast.exception.ServiceException;
import com.wecast.request.Friend;
import com.wecast.service.FriendService;

@RestController
public class FriendController {

	@Autowired
	private FriendService friendService;

	@PostMapping("/addfriend")
	public ResponseEntity<Friend> addFriend(@RequestBody Friend friend) {
		Friend returnFriend = friendService.sendFriendRequest(friend);
		return ResponseEntity.ok().body(returnFriend);
	}

	@GetMapping("/acceptfriendrequest/{sender_id}/{reciever_id}")
	public ResponseEntity<Friend> acceptFrndRequest(@PathVariable int sender_id, @PathVariable int reciever_id) {
		Friend ret = null;
		ret = friendService.acceptFriendRequest(sender_id, reciever_id);
		return ResponseEntity.ok().body(ret);
	}

	@GetMapping("/getlistoffriends/{user_id}")
	public ResponseEntity<List<Friend>> getFriendList(@PathVariable int user_id) {
		List<Friend> fList = null;
		try {
			fList = friendService.retriveFriendList(user_id);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}
		return ResponseEntity.ok().body(fList);
	}

}
