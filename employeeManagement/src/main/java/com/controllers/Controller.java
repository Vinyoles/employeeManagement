package com.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Controller //TODO comparar amb la Lara, en principi el org era un import i el controller anava sol
@RequestMapping("")
public class Controller {
	
	@GetMapping("/")
	public String start() {
		return "login";
	}
	
	@PostMapping("/")
	public String login() {
		return "consulting";
	}

	

}
