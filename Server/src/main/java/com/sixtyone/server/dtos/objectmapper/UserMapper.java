package com.sixtyone.server.dtos.objectmapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sixtyone.server.dtos.UserDTO;
import com.sixtyone.server.model.User;

@Mapper
public interface UserMapper {
		
		UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
		@Mapping(target = "createdTime",source = "createdAt")
		UserDTO userToUserDTO(User user);
}
