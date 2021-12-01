package com.wecast.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wecast.repo.ProfileRepository;
import com.wecast.repo.ProjectRepository;
import com.wecast.request.Profile;
import com.wecast.request.Project;
import com.wecast.request.User;
import com.wecast.request.UserRequest;
import com.wecast.service.ProfileService;
import com.wecast.service.ProjectService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ProfileControllerTest2 {

	@InjectMocks
	private ProfileLikeCommentController controller;

	@Mock
	private ProfileService service;

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

	@Test
	public void commentedByTest() {
		when(service.commentBy(1, 2, "Nice")).thenReturn("ABC");
		ResponseEntity<String> responseEntity = controller.commentedBy(profile);
		Assert.assertNull(responseEntity.getBody());

	}

	/*
	 * @Test public void likeByTest() { when(service.likedBy(1, 2)).thenReturn("");
	 * ResponseEntity<String> responseEntity = controller.likeBy(profile);
	 * assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); }
	 */

}
