package configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import dtos.UserDTO;
import serializers.UserObjectDeserializer;

/**
 * Kafka client configuration class.
 * **/
@Configuration
@EnableKafka
public class ClientConfig {

	
	@Bean
	public ConsumerFactory<String,UserDTO> consumerFactory(){
		Map<String,Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,ConsumerConfigProperties.SERVER_ADDRESS.getEnumVal());
		configProps.put(ConsumerConfig.GROUP_ID_CONFIG,ConsumerConfigProperties.GROUP_ID_CLIENT.getEnumVal());
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,UserObjectDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(configProps);
	}
	
	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,UserDTO>> listenerFactory(){
		
		ConcurrentKafkaListenerContainerFactory<String,UserDTO> 
				concurrentKafkaListenerContainerFactory =
						new ConcurrentKafkaListenerContainerFactory<>();
		concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
		
		return concurrentKafkaListenerContainerFactory;
	}
}
