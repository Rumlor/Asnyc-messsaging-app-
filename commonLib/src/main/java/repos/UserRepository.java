package repos;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import models.User;


public interface UserRepository extends CassandraRepository<User, Integer> {

	
}
