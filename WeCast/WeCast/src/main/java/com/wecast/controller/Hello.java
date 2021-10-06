package com.wecast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	String str="Hello Neha..";
	
	@GetMapping("/hello")
	public String showData(){
		return str;
	}
}
