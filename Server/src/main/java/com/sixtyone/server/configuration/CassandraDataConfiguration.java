package com.sixtyone.server.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.sixtyone.server.configuration.resourceproperties.CassandraDataConfigProperties;

@Configuration
@EnableConfigurationProperties(CassandraDataConfigProperties.class)
@EnableCassandraRepositories(basePackages = "com.sixtyone.server.repositoriess")
@ComponentScan("com.sixtyone.server.repositoriess")
public class CassandraDataConfiguration extends AbstractCassandraConfiguration{
	
	
	
	private CassandraDataConfigProperties properties;
	
	@PostConstruct
	public void init () {
		System.out.println("are properties injected? "+ !(properties == null) );
	}
	

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
		return schemaAction;
	}

	
	@Autowired
	public void setProperties(CassandraDataConfigProperties properties) {
		this.properties = properties;
	}
	

	
}
