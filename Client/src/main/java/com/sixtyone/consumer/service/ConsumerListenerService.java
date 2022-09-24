package com.sixtyone.consumer.service;

import dtos.UserDTO;

public interface ConsumerListenerService {

	void listenUserData(UserDTO dto);
}
