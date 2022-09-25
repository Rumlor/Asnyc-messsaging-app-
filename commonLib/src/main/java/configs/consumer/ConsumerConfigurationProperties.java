package configs.consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;

import configs.AppConstants;
import lombok.Data;

@ConfigurationProperties(prefix = AppConstants.EVENT_STREAMING_CONFIG_PREFIX)
@Data
public class ConsumerConfigurationProperties {
	private String brokerBootstrapAddress;
	private String consumerGroupId;
}
