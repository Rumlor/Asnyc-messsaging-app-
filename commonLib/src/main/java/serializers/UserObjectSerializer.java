package serializers;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import dtos.UserDTO;


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
		
		return SerializationUtils.serialize(data);
		
	
		
	}

}
