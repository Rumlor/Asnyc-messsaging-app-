package com.sixtyone.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.sixtyone.server.configuration.CassandraDataConfiguration;
import com.sixtyone.server.configuration.messageproducer.MessageProducerConfiguration;
import dtos.*;
import com.sixtyone.server.repositoriess.UserRepository;

@SpringBootTest(classes = MessageProducerConfiguration.class)
public class MainIntegrationTest {

	@Autowired
	private KafkaTemplate<String,UserDTO> template;
	

	@Test
	public void testInjectionIsOK() {
		assertThat(template).isNotNull();
	}
	
	@Test
	public void sendFirstMessage() {
		//assertDoesNotThrow( ()-> template.send("usertopic","First Message from test") );
	}
	
	@Test
	public void testSerialization() {
		UserDTO dto = UserDTO.builder()
				.createdTime(Timestamp.from(Instant.now()))
				.followerList(List.of(2))
				.name("mehmet")
				.surname("dogan")
				.id(61).build();
		
		template.send("usertopic",dto);
		dto.setName("emirhan");
		template.send("usertopic",dto);
	}

	
}
