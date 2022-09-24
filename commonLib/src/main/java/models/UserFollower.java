package models;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import dtos.UserFollowerDTO;
import lombok.Getter;
import lombok.Setter;


@Table("sixty_one_app_table_first")
@Getter
@Setter
public class UserFollower extends GenericModel<UserFollower,UserFollowerDTO> {

	@Column @PrimaryKey private int id;
	@Column private int boundUserId;
    @Column	private Timestamp createdAt;
	

	@Override
	protected void mapFromCorrespondingDTO(UserFollowerDTO dtoObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserFollowerDTO mapToCorrespondingDTO() {
		// TODO Auto-generated method stub
		return null;
	}

}
