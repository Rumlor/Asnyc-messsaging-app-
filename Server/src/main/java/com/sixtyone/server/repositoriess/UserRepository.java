package com.sixtyone.server.repositoriess;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.sixtyone.server.model.User;

public interface UserRepository extends CassandraRepository<User, Integer> {

}
