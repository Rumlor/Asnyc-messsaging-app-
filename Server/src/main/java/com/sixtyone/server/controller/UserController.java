package com.sixtyone.server.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sixtyone.server.dtos.UserDTO;
import com.sixtyone.server.services.UserDAOService;

@RestController
@RequestMapping(path = "/users",consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	private UserDAOService userDAOService;
	
	
	public UserController (UserDAOService service) {
		this.userDAOService = service;
	}
	@PostMapping(path = "/new")
	public ResponseEntity< Map<String,Object> > postNewUser(@RequestBody UserDTO user) {
		userDAOService.insertNewUser(user);
		return  ResponseEntity.ok(Map.of("success",true,"message","User saved succesfully"));
	}
}
