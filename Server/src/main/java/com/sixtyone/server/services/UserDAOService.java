package com.sixtyone.server.services;

import com.sixtyone.server.dtos.UserDTO;

public interface UserDAOService {
	
	void insertNewUser (UserDTO userDTO);
	
	UserDTO getUserFrom(int id);
	
}
