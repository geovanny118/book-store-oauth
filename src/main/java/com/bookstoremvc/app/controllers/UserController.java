package com.bookstoremvc.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoremvc.app.entities.UserEntity;
import com.bookstoremvc.app.services.UserService;


@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<Object> creaUser(@RequestBody UserEntity user) {
		return userService.addUser(user);
	}
}
