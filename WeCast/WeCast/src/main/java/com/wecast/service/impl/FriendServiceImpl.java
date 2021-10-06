package com.wecast.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecast.exception.ServiceException;
import com.wecast.repo.FriendRepository;
import com.wecast.request.Friend;
import com.wecast.request.User;
import com.wecast.service.FriendService;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendRepository friendRepository;

	@Override
	public Friend sendFriendRequest(Friend friend) {
		Friend f1= new Friend();
		f1.setSender_id(friend.getSender_id());
		f1.setReciever_id(friend.getReciever_id());
		f1.setRequest_DT(Instant.now());
		f1.setAccept_DT(friend.getAccept_DT());
		f1.setStatus(friend.getStatus());
	//	friend.setRequest_DT(new Date());
		Friend frnd=friendRepository.save(f1);
		return frnd;
	}
	
	@Override
	public Friend acceptFriendRequest(int sender_id, int reciever_id) {
		Friend newFrnd = null;
		Friend frnd = friendRepository.acceptFriendRequest(sender_id ,reciever_id);
		if(frnd!=null) {
			frnd.setStatus("Friend");
			frnd.setAccept_DT(Instant.now());
			 newFrnd	= friendRepository.save(frnd);
			 
		}
		return newFrnd;
		
	}
	public List<Friend> retriveFriendList(int user_id) throws ServiceException {
		List<Friend> friends= friendRepository.retriveFriendList(user_id);
		if(friends.isEmpty()) {
			throw new ServiceException("No friends yet..");
		}

		return friends;
	}
}
