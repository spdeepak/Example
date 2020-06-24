package com.deepaksp.mongodbdemo.repository;

import com.deepaksp.mongodbdemo.entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
}
