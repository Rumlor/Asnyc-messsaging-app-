package com.sixtyone.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.sixtyone.server.configuration.CassandraDataConfiguration;
import com.sixtyone.server.repositoriess.UserRepository;

@ContextConfiguration(classes = CassandraDataConfiguration.class)
@Rollback(value = true)
public class MainIntegrationTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void RepoIsInjectedTest() {
		assertThat(repository).isNotNull();
	}
	
	@Test
	public void repoFindOneTest() {
		assertThat(repository.findAll().size()).isEqualTo(4);
	}
	
	@Test
	public void testNullForDaysCount() {
		assertThrows( NullPointerException.class, 
					()-> ChronoUnit.DAYS.between(LocalDate.now(),null));
	}
	
	
}
