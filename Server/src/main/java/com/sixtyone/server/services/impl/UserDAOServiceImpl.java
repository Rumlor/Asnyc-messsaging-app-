package com.sixtyone.server.services.impl;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

import org.springframework.stereotype.Repository;

import com.sixtyone.server.repositoriess.UserRepository;
import com.sixtyone.server.services.UserDAOService;
import com.sixtyone.server.services.UserEventProducer;

import dtos.UserDTO;
import models.User;

@Repository
public class UserDAOServiceImpl  implements UserDAOService{

	private UserRepository repository;
	private UserEventProducer eventProducer;
	private static final Logger LOGGER = Logger.getLogger(UserDAOServiceImpl.class.getName());
	
	public UserDAOServiceImpl(UserRepository repository,UserEventProducer producer) {
		this.eventProducer = producer;
		this.repository = repository;
	}
	
	@Override
	public void insertNewUser(UserDTO userDTO) {
		LOGGER.info("Inserting new User to DB");
		User userToBeSaved = new User();
		userToBeSaved.mapFromCorrespondingDTO(userDTO);
		repository.save(userToBeSaved);
		eventProducer.sendEventDetail(userDTO);
	}

	@Override
	public UserDTO getUserFrom(int id) {
		
		Optional<User> user =  repository.findById(id);
		AtomicReference<UserDTO> dto = new AtomicReference<>();
		
		user.ifPresentOrElse(userLambda-> dto.set(userLambda.mapToCorrespondingDTO()) , 
						()-> new RuntimeException("User not found."));
		
		return dto.get();
	}

}
