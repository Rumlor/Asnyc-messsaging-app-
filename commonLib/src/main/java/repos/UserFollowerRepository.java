package repos;

import org.springframework.data.cassandra.repository.CassandraRepository;

import models.UserFollower;

public interface UserFollowerRepository  extends CassandraRepository<UserFollower,Integer>{

}
