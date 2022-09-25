package com.sixtyone.consumer.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.sixtyone.consumer.service.ConsumerListenerService;
import com.sixtyone.consumer.service.UserFollowerService;

import dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerListenerServiceImpl  implements ConsumerListenerService {

	private final UserFollowerService userFollowerService;
	
	@KafkaListener(topics = "usertopic",containerFactory = "listenerFactory" )
	public void listenUserData(UserDTO dto) {
		log.info("Message received.. saving follower info!");
		userFollowerService.saveUserFollower(dto);
	}

}
