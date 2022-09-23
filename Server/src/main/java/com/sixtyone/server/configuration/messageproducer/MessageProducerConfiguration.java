package com.sixtyone.server.configuration.messageproducer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sixtyone.server.configuration.resourceproperties.KafkaProducerConfigProperties;
import com.sixtyone.server.dataserializer.UserObjectSerializer;
import com.sixtyone.server.dtos.UserDTO;


@Configuration
@EnableConfigurationProperties(KafkaProducerConfigProperties.class)
public class MessageProducerConfiguration {

	@Autowired
	private KafkaProducerConfigProperties properties;
	
	
	@Bean
	public ProducerFactory<String,UserDTO> demoProducerFactory(){
		
		System.out.println("PROPERTY!"+properties.getBrokerBootstrapAddress());
		Map<String,Object> configProps = new HashMap<>();

		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,properties.getBrokerBootstrapAddress());
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,UserObjectSerializer.class);
			
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	
	@Bean
	public KafkaTemplate<String,UserDTO> kafkaTemplate(){
		return new KafkaTemplate<>(demoProducerFactory());
	}
	
	@Bean
	public ObjectMapper serializer() {
		return new ObjectMapper();
	}
}
