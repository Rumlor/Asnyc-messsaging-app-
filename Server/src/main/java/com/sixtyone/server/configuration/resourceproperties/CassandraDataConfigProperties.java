package com.sixtyone.server.configuration.resourceproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "sixtyone.data")
public class CassandraDataConfigProperties {

	private String uername = null;
	private String password = null;
	private String contactPoints = null;
	private String keySpace = null;
	private int port;
	private String schemaAction = null;
	
	
	public String getUername() {
		return uername;
	}
	public void setUername(String uername) {
		this.uername = uername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactPoints() {
		return contactPoints;
	}
	public void setContactPoints(String contactPoints) {
		this.contactPoints = contactPoints;
	}
	public String getKeySpace() {
		return keySpace;
	}
	public void setKeySpace(String keySpace) {
		this.keySpace = keySpace;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getSchemaAction() {
		return schemaAction;
	}
	public void setSchemaAction(String schemaAction) {
		this.schemaAction = schemaAction;
	}
	
}
