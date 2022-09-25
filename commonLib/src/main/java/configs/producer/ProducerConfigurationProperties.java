package configs.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;

import configs.AppConstants;
import lombok.Data;

@ConfigurationProperties(prefix = AppConstants.EVENT_STREAMING_CONFIG_PREFIX)
@Data
public class ProducerConfigurationProperties {

	private String brokerBootstrapAddress;
}
