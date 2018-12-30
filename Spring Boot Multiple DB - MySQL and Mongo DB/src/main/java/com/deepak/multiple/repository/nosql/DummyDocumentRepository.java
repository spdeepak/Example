package com.deepak.multiple.repository.nosql;

import com.deepak.multiple.entity.nosql.DummyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyDocumentRepository extends MongoRepository<DummyDocument, String> {
}
