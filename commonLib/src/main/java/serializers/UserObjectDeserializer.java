package serializers;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.serialization.Deserializer;

import dtos.UserDTO;




public class UserObjectDeserializer implements Deserializer<UserDTO>{

	

	
	public UserObjectDeserializer() {}
	
	@Override
	public UserDTO deserialize(String topic, byte[] data) {
	
		UserDTO dto = SerializationUtils.<UserDTO>deserialize(data);
	
		return dto;
	}

}
