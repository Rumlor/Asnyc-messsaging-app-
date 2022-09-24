package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import dtos.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Table("sixty_one_app_table_first")
@Getter
@Setter
public class User extends GenericModel<User,UserDTO> {
	
	@PrimaryKey @Column private int id;
	@Column private String name;
	@Column private String surname;
	@Column private List<Integer> followerList = new ArrayList<>();
	@Column private Timestamp createdAt;
	
	
	@Override
	public void mapFromCorrespondingDTO(UserDTO dtoObject) {
		
		BeanUtils.copyProperties(dtoObject,this);
		this.createdAt = dtoObject.getCreatedTime();
		
	}


	@Override
	public UserDTO mapToCorrespondingDTO() {
		UserDTO dto = UserDTO.builder().build();
		BeanUtils.copyProperties(this,dto);
		dto.setCreatedTime(createdAt);
		return dto;
	}

}
