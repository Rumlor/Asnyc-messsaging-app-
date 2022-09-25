package configs.producer;



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

import dtos.UserDTO;
import lombok.extern.slf4j.Slf4j;
import serializers.UserObjectSerializer;


@Configuration
@EnableConfigurationProperties(ProducerConfigurationProperties.class)
@Slf4j
public class ProducerConfiguration {

	
	private ProducerConfigurationProperties producerConfigurationProperties;
	
	@Bean
	public KafkaTemplate<String,UserDTO> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	
	
	@Bean
	public ProducerFactory<String,UserDTO> producerFactory(){
		return new DefaultKafkaProducerFactory(configProperties());
	}

	
	private Map<String,Object> configProperties() {
		Map <String ,Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,producerConfigurationProperties.getBrokerBootstrapAddress());
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,UserObjectSerializer.class);
		
		return props;
	}

	
	
	@Autowired
	public void setProducerConfigurationProperties(ProducerConfigurationProperties producerConfigurationProperties) {
		log.info("Producer config property of proprty source is initialized with bootstrap address {}",
				producerConfigurationProperties.getBrokerBootstrapAddress());

		this.producerConfigurationProperties = producerConfigurationProperties;
	}
}
