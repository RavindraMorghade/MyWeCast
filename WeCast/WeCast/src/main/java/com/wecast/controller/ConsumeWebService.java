package com.wecast.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wecast.request.Employee;
import com.wecast.request.UserRequest;
@RestController
public class ConsumeWebService {
	
	@Autowired
	   RestTemplate restTemplate;

	   @GetMapping("/callHeroku")
	   public String getProductList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("https://firstapplicationdemo.herokuapp.com/heroku", HttpMethod.GET, entity, String.class).getBody();
	   }
	   
	   @PostMapping("/registeremployee")
	   public String registerEmployee(@RequestBody UserRequest userRequest) {
		   HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity<UserRequest> entity = new HttpEntity<UserRequest>(userRequest,headers);
			
		      return restTemplate.exchange("https://firstapplicationdemo.herokuapp.com/registerUser", HttpMethod.POST, entity, String.class).getBody();
		    	   }
		}


