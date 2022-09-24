package com.sixtyone.server.services;

import java.util.List;

import dtos.UserDTO;

public interface UserEventProducer {

	/**
	 * Sends user id and follower list to the broker.
	 * */
	void sendEventDetail(UserDTO userToBeSendOverToBroker);
}
