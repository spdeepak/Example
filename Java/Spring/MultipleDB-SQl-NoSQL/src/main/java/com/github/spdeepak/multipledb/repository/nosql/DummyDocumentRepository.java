package com.github.spdeepak.multipledb.repository.nosql;

import com.github.spdeepak.multipledb.entity.nosql.DummyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyDocumentRepository extends MongoRepository<DummyDocument, String> {
}
