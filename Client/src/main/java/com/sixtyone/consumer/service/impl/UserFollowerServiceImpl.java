package com.sixtyone.consumer.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Random;
import java.util.random.RandomGenerator;

import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import com.sixtyone.consumer.service.UserFollowerService;

import dtos.UserDTO;
import dtos.UserFollowerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import models.UserFollower;
import repos.UserFollowerRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserFollowerServiceImpl implements UserFollowerService {

	private final UserFollowerRepository userFollowerRepository;
	
	@Override
	public void saveUserFollower(UserDTO dto) {
		UserFollowerDTO userFollowerDTO = 	UserFollowerDTO.builder()
										.boundUserId(dto.getId())
										.createdAt(Timestamp.from(Instant.now()))
										.id(RandomGenerator.getDefault().nextInt(1000)).build();
		
		UserFollower userFollower = new UserFollower();
		userFollower.mapFromCorrespondingDTO(userFollowerDTO);
		userFollowerRepository.save(userFollower);
		log.info("User follower is saved succesfully");
		
	}

}
