package com.wecast.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecast.exception.ServiceException;
import com.wecast.repo.LikeAndCommentRepository;
import com.wecast.repo.UserRepository;
import com.wecast.request.LikeAndComment;
import com.wecast.request.User;
import com.wecast.service.LikeAndCommentService;

@Service
public class LikeAndCommentImpl implements LikeAndCommentService {

	@Autowired
	private LikeAndCommentRepository likeAndCommentRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public LikeAndComment likeBy(Integer likeById, Integer profileId) {
		LikeAndComment likeAndComment = new LikeAndComment();
		likeAndComment.setLikedById(likeById);
		likeAndComment.setProfileId(profileId);
		LikeAndComment newLAndC = likeAndCommentRepository.save(likeAndComment);
		return newLAndC;

	}

	@Override
	public LikeAndComment commentBy(Integer commentById, Integer profileId, String textComment) {
		LikeAndComment likeAndComment = new LikeAndComment();
		likeAndComment.setCommentById(commentById);
		likeAndComment.setProfileId(profileId);
		likeAndComment.setTextComments(textComment);
		LikeAndComment newLAndC = likeAndCommentRepository.save(likeAndComment);
		return newLAndC;

	}

	/*
	 * @Override public List<LikeAndComment> findLikesOnProfile(Integer profile_id){
	 * List<LikeAndComment> likeAndComment =
	 * likeAndCommentRepository.findLikesOnProfile(profile_id); return
	 * likeAndComment;
	 * 
	 * }
	 */

	@Override
	public List<User> findLikesOnProfile(Integer profile_id) throws ServiceException {
		List<Integer> userlist = new ArrayList<>();
		List<LikeAndComment> list = likeAndCommentRepository.findLikesOnProfile(profile_id);
		if (list.isEmpty()) {
			throw new ServiceException("Likes not found");
		} else {
			for (LikeAndComment likeAndComment : list) {
				userlist.add(likeAndComment.getLikedById());
			}
			List<User> uList = userRepository.findAllUsers(userlist);
			return uList;
		}

	}

	@Override
	public List<User> findCommentsOnProfile(Integer profile_id) throws ServiceException {
		List<Integer> userlist = new ArrayList<>();
		List<LikeAndComment> list = likeAndCommentRepository.findCommentsOnProfile(profile_id);
		if (list.isEmpty()) {
			throw new ServiceException("Comments not found");
		} else {
			for (LikeAndComment likeAndComment : list) {
				userlist.add(likeAndComment.getCommentById());
			}
			List<User> uList = userRepository.findAllUsers(userlist);
			return uList;
		}

	}
}
