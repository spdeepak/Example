package com.deepaksp.mongodbdemo.repository;

import com.deepaksp.mongodbdemo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

}
