package com.deepak.multiple;

import com.deepak.multiple.entity.Dummy;
import com.deepak.multiple.entity.nosql.DummyDocument;
import com.deepak.multiple.entity.sql.DummyEntity;
import com.deepak.multiple.repository.nosql.DummyDocumentRepository;
import com.deepak.multiple.repository.sql.DummyEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DummyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummyApplication.class, args);
	}

	@Bean
	CommandLineRunner createDummyEntityData(DummyEntityRepository dummyRepository) {
		return args -> {
			dummyRepository.deleteAll();
			List<DummyEntity> dummies = List.of(new DummyEntity("Dummy Description One"), new DummyEntity("Dummy Description Two"), new DummyEntity("Dummy Description Three"));
			dummyRepository.saveAll(dummies);
		};
	}

	@Bean
	CommandLineRunner createDummyDocumentData(DummyDocumentRepository dummyDocumentRepository) {
		return args -> {
			dummyDocumentRepository.deleteAll();
			List<DummyDocument> dummies = List.of(new DummyDocument(new Dummy("Dummy Description One")), new DummyDocument(new Dummy("Dummy Description Two")), new DummyDocument(new Dummy("Dummy Description Three")));
			dummyDocumentRepository.saveAll(dummies);
		};
	}

}
