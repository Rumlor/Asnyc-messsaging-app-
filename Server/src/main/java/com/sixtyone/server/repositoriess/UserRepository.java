package com.sixtyone.server.repositoriess;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.sixtyone.server.model.User;

public interface UserRepository extends CassandraRepository<User, Integer> {

	
}
