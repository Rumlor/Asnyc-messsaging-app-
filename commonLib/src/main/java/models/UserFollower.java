package models;

import java.sql.Timestamp;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import dtos.UserFollowerDTO;

import lombok.Getter;
import lombok.Setter;


@Table("sixty_one_app_table_first_follower")
@Getter
@Setter

public class UserFollower extends GenericModel<UserFollower,UserFollowerDTO> {

	@Column @PrimaryKey private int id;
	@Column private int boundUserId;
    @Column	private Timestamp createdAt;
	

	@Override
	public void mapFromCorrespondingDTO(UserFollowerDTO dtoObject) {
		
		 this.id = dtoObject.getId();
		 this.boundUserId = dtoObject.getBoundUserId();
		 this.createdAt = dtoObject.getCreatedAt();
	}

	@Override
	public UserFollowerDTO mapToCorrespondingDTO() {
		
		return UserFollowerDTO.builder().boundUserId(boundUserId)
										.createdAt(createdAt)
										.id(id).build();
	}

}
