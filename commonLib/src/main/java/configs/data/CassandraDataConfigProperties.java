package configs.data;


import org.springframework.boot.context.properties.ConfigurationProperties;

import configs.AppConstants;
import lombok.Data;

@ConfigurationProperties(prefix = AppConstants.CASSANDRA_DATA_PREFIX)
@Data
public class CassandraDataConfigProperties {

	private String uername = null;
	private String password = null;
	private String contactPoints = null;
	private String keySpace = null;
	private int port;
	private String schemaAction = null;
	

	
}
