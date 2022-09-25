package com.sixtyone.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import configs.data.CassandraDataConfiguration;
import configs.producer.ProducerConfiguration;

@SpringBootApplication
@Import(value = {CassandraDataConfiguration.class,ProducerConfiguration.class})
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
