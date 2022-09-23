package com.sixtyone.server.dataserializer;

import org.apache.kafka.common.serialization.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sixtyone.server.dtos.UserDTO;


public class UserObjectSerializer implements Serializer<UserDTO>{

	
	private ObjectMapper serializer = new ObjectMapper();
	
	public UserObjectSerializer() {//no arg constructor.}
		
	}
	
	@Override
	public byte[] serialize(String topic, UserDTO data) {

		byte[] array = null;
		
		if (data == null ) {
			return array;
		}
		try {
		
			array = serializer.writeValueAsBytes(data);
		
		} catch (JsonProcessingException e) {
			System.out.println("An error was encountered during serialization.");
			e.printStackTrace();
		}
		
		return array;
	}

}
