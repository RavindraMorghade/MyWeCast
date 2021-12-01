package com.wecast.service;

public interface ProfileService{

	String likedBy(int pid, int userId);

	//String commentBy(int profileId, int userId, int textComments);

	String commentBy(int profileId, int userId, String textComment);

}
