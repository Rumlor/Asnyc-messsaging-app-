package configs.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import lombok.extern.slf4j.Slf4j;
import models.User;
import repos.UserRepository;



@Configuration
@EnableConfigurationProperties(CassandraDataConfigProperties.class)
@EnableCassandraRepositories(basePackageClasses = UserRepository.class)
@Slf4j
public class CassandraDataConfiguration extends AbstractCassandraConfiguration{
	
	
	
	private CassandraDataConfigProperties properties;
		

	@Override
	protected String getKeyspaceName() {
		return properties.getKeySpace();
	}
	
	@Override
	protected String getContactPoints() {
		return properties.getContactPoints();
	}
	
	@Override
	protected int getPort() {
		return properties.getPort();
	}
	
	@Override
	public SchemaAction getSchemaAction() {
		SchemaAction schemaAction =	Enum.valueOf(SchemaAction.class,properties.getSchemaAction());
		log.info("Schema Action of service is {}",schemaAction);
		return schemaAction;
	}

	@Override
	public String[] getEntityBasePackages() {
		return new String[] {User.class.getPackage().getName()};
	}
	
	@Autowired
	public void setProperties(CassandraDataConfigProperties properties) {
		log
		.info("Cassandra Data Configurations are initilizing. properties are injected: contact-points{},keyspace-name:{}",properties.getContactPoints(),properties.getKeySpace());
		this.properties = properties;
	}
	

	
}
