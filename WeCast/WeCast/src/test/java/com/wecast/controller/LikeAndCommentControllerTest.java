package com.wecast.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wecast.repo.LikeAndCommentRepository;
import com.wecast.request.LikeAndComment;
import com.wecast.service.LikeAndCommentService;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class LikeAndCommentControllerTest {
	
	@InjectMocks
	private LikeAndCommentController controller;
	
	@Mock
	private LikeAndCommentService service;
	
	private LikeAndCommentRepository repository;
	@Mock
	private LikeAndComment likeAndComment;
	
	@Test
	public void likedBy() {
		when(service.likeBy(1, 5)).thenReturn(likeAndComment);
		ResponseEntity<LikeAndComment> responseEntity = controller.likedBy(likeAndComment);
		assertEquals(HttpStatus.OK	, responseEntity.getStatusCode());
		
	}

	
}
