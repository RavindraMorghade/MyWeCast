package com.wecast.service;

import java.util.List;

import com.wecast.exception.ServiceException;
import com.wecast.request.LikeAndComment;
import com.wecast.request.User;

public interface LikeAndCommentService {

	LikeAndComment likeBy(Integer likeById, Integer profileId);

	LikeAndComment commentBy(Integer commentById, Integer profileId, String textComment);

	List<User> findLikesOnProfile(Integer profile_id) throws ServiceException;
	
	public List<User> findCommentsOnProfile(Integer profile_id) throws ServiceException;



}
