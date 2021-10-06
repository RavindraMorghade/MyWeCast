package com.wecast.service;

import java.util.List;

import com.wecast.exception.ServiceException;
import com.wecast.request.Friend;

public interface FriendService {
	
	public Friend sendFriendRequest(Friend friend);

	Friend acceptFriendRequest(int sender_id, int reciever_id);

	public List<Friend> retriveFriendList(int user_id)  throws ServiceException;

}
