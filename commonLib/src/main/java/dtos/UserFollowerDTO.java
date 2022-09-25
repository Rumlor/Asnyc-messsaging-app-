package dtos;

import java.sql.Timestamp;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserFollowerDTO {

	private int id;
	private int boundUserId;
    private Timestamp createdAt;
}
