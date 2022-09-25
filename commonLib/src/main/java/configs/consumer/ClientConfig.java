package configs.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import dtos.UserDTO;
import lombok.extern.slf4j.Slf4j;
import serializers.UserObjectDeserializer;

/**
 * Kafka client configuration class.
 * **/
@Configuration
@EnableKafka
@EnableConfigurationProperties(ConsumerConfigurationProperties.class)
@Slf4j
public class ClientConfig {

	private static final String NO_INITIAL_OFFSET_STRATEGY = "earliest";
	
	
	private ConsumerConfigurationProperties consumerConfigurationProperties;
	
	@Autowired
	public void setConsumerConfigurationProperties(ConsumerConfigurationProperties consumerConfigurationProperties) {
		log.info("Consumer config property of proprty source is initialized with bootstrap address {}",consumerConfigurationProperties.getBrokerBootstrapAddress());
		this.consumerConfigurationProperties = consumerConfigurationProperties;
	}
	
	@Bean
	public ConsumerFactory<String,UserDTO> consumerFactory(){
		Map<String,Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,consumerConfigurationProperties.getBrokerBootstrapAddress());
		configProps.put(ConsumerConfig.GROUP_ID_CONFIG,consumerConfigurationProperties.getConsumerGroupId());
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,UserObjectDeserializer.class);
		//commits latest offset that is read by consumer and will start fetching if there is data available after that offset.
		configProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		//start reading from first message.
		configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, NO_INITIAL_OFFSET_STRATEGY);
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
