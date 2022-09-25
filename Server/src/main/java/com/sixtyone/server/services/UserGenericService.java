package com.sixtyone.server.services;

import dtos.UserDTO;

public interface UserGenericService {
	
	void insertNewUser (UserDTO userDTO);
	
	UserDTO getUserFrom(int id);
	
}
