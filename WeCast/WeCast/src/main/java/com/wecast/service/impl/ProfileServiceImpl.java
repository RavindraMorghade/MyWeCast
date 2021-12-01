package com.wecast.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecast.repo.ProfileRepository;
import com.wecast.request.Profile;
import com.wecast.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{
	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public String likedBy(int profileId, int userId) {
		Optional<Profile> retProfile= profileRepository.findById(profileId);
		if(retProfile.isPresent()) {
			 retProfile.get().setLikeBy(userId);
			profileRepository.save( retProfile.get());
			return "You Liked Successfully";
		}
		return null;
		
	}
	
	@Override
	public String commentBy(int profileId, int userId, String textComment) {
		Optional<Profile> retProfile = profileRepository.findById(profileId);
		if(retProfile.isPresent()) {
			retProfile.get().setCommentBy(userId);
			retProfile.get().setTextComments(textComment);
			profileRepository.save(retProfile.get());
			return "You commented successfully";
		}
		return null;
		
	}
}
