package com.sixtyone.server.configuration.resourceproperties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.ToString;

@ConfigurationProperties(prefix = "sixtyone.messaging")
@Data
@ToString
public class KafkaProducerConfigProperties implements InitializingBean {

	private String brokerBootstrapAddress;
	private String keySerializer;
	private String valueSerializer;
	@Override
	public void afterPropertiesSet() throws Exception {
		this.toString();
		
	}
}
