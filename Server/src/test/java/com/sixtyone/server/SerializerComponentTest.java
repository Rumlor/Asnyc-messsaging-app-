package com.sixtyone.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import dtos.UserDTO;
import serializers.UserObjectDeserializer;
import serializers.UserObjectSerializer;

public  class SerializerComponentTest {

	private static UserDTO dto = null;
	private static UserObjectSerializer serializer = null;
	private static UserObjectDeserializer deserializer = null;
	
	@BeforeAll
	public static void initializeTestData() {
		
		serializer = new UserObjectSerializer();
		deserializer = new UserObjectDeserializer();
		dto = 	UserDTO.builder()
									.name("mehmet").surname("dogan")
									.followerList(List.of(3,4))
									.createdTime(Timestamp.from(Instant.now()))
									.build();
	
	}
	
	@Test
	public void serializingObjectIntoByteArrayTest() {
		
		byte[] array =  serializer.serialize("topic",dto);
		assertThat(array.length).isGreaterThan(0);
	}
	
	
	@Test
	public void deserializingByteArrayToObject() {
		byte[] array =  serializer.serialize("topic",dto);
		UserDTO deserializedDto = deserializer.deserialize("topic",array);
		assertThat(deserializedDto.getName()).isEqualTo("mehmet");
		assertThat(deserializedDto).isEqualTo(dto);
	}
	
	@Test
	public void serializerReturnsNullWhenNullDataPassedTest() {
		UserDTO dto = null;
		assertNull(serializer.serialize("topic",dto));
	}
	
	
}
