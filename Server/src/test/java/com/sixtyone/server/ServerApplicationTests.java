package com.sixtyone.server;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sixtyone.server.model.User;
import com.sixtyone.server.services.UserDAOService;

@SpringBootTest
class ServerApplicationTests {
	
	
	@Autowired
	private UserDAOService userDAOService;
	
	@Test
	public void insertNewTest() {
		User user = new User();
		user.setId(12);
		user.setName("rumlor");
		user.setSurname("zendar");
		user.setCreatedAt(Timestamp.from(Instant.now()));
		user.setFollowerList(List.of(3,12));
		assertDoesNotThrow(()->userDAOService.insertNewUser(user.mapToCorrespondingDTO()));
	}
	
	
	@Test
	void contextLoads() {
	}

}
