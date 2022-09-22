package com.sixtyone.server.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("sixty_one_app_table_first")
@Getter
@Setter
public class User {
	
	@PrimaryKey @Column private int id;
	@Column private String name;
	@Column private String surname;
	@Column private List<Integer> followerList = new ArrayList<>();
	@Column private Timestamp createdAt;

}
