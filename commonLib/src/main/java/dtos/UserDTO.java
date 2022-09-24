package dtos;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	 private String name;
	 private String surname;
	 private List<Integer> followerList = new ArrayList<>();
	 private Timestamp createdTime;
	
}
