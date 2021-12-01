package com.wecast.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wecast.exception.ServiceException;
import com.wecast.repo.FriendRepository;
import com.wecast.request.Friend;
import com.wecast.service.FriendService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class FriendControllerTest {

	@InjectMocks
	private FriendController controller;
	@Mock
	private FriendService service;

	private Friend friend;
	private FriendRepository repository;
	private List<Friend> list = new ArrayList<>();

	@Before
	public void setup() throws Exception {
		list.add(friend);
	}

	@Test
	public void addFriend() {
		when(service.sendFriendRequest(friend)).thenReturn(friend);
		ResponseEntity<Friend> responseEntity = controller.addFriend(friend);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void acceptFrndRequest() {
		when(service.acceptFriendRequest(1, 3)).thenReturn(friend);
		ResponseEntity<Friend> responseEntity = controller.acceptFrndRequest(1, 3);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void getFriendListTest() throws ServiceException {
		when(service.retriveFriendList(2)).thenReturn(list);
		ResponseEntity<List<Friend>> responseEntity = controller.getFriendList(2);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void getFriendListTestFailure() throws ServiceException {
		when(service.retriveFriendList(2)).thenThrow(new ServiceException("No friends yet."));
		ResponseEntity<List<Friend>> responseEntity = controller.getFriendList(2);
		Assert.assertNotNull(responseEntity);
	}

}
