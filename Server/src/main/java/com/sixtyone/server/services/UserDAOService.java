package com.sixtyone.server.services;

import dtos.UserDTO;

public interface UserDAOService {
	
	void insertNewUser (UserDTO userDTO);
	
	UserDTO getUserFrom(int id);
	
}
