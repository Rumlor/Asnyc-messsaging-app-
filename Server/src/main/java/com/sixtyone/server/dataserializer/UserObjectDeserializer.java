package com.sixtyone.server.dataserializer;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sixtyone.server.dtos.UserDTO;

@Component
public class UserObjectDeserializer implements Deserializer<UserDTO>{

	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public UserDTO deserialize(String topic, byte[] data) {
	
		UserDTO dto = null;
		try {
		dto = mapper.readValue(data,UserDTO.class);
		} catch (Exception e) {
			System.out.println("Error encountered during deserialization.");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return dto;
	}

}
