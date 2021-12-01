package com.wecast.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wecast.repo.ProfileRepository;
import com.wecast.request.Profile;
import com.wecast.request.User;
import com.wecast.request.UserRequest;
import com.wecast.service.ProfileService;
import com.wecast.service.impl.ProfileServiceImpl;

class ProfileLikeCommentControllerTest2 {

	@InjectMocks
	private ProfileLikeCommentController controller;

	@Mock
	private ProfileServiceImpl service;

	private Profile profile;
	private List<User> userList = new ArrayList<User>();
	private UserRequest userRequest;
	private List<Profile> profileList = new ArrayList<>();

	private ProfileRepository repository;

	@Before
	public void setup() throws Exception {
		profile = Profile.builder().id(2).userId(1).profileName("Fedex").likeBy(1).build();
		// profileList.add(profile);
	}

	@Test
	public void likeByTest() {
		when(service.likedBy(1, 2)).thenReturn("Very nice");
		ResponseEntity<String> responseEntity = controller.likeBy(profile);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
