package com.sixtyone.consumer.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.sixtyone.consumer.service.ConsumerListenerService;

import dtos.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerListenerServiceImpl  implements ConsumerListenerService {

	
	@KafkaListener(topics = "usertopic",containerFactory = "listenerFactory" )
	public void listenUserData(UserDTO dto) {
		log.info("Message received:"+dto.getName());
	}

}
