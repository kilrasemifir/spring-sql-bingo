package com.semifir.bingo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semifir.bingo.services.UserService;

@RestController
@RequestMapping("debug")
@CrossOrigin
@Profile("dev")
public class DebugController {

	@Autowired
	private UserService userService;
	
	@DeleteMapping("all")
	public void drop() {
		this.userService.deleteAll();
	}
}
