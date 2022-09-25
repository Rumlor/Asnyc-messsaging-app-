package com.sixtyone.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import configs.consumer.ClientConfig;
import configs.data.CassandraDataConfiguration;

@SpringBootApplication
@Import(value = {ClientConfig.class,CassandraDataConfiguration.class})
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

}
