package com.github.spdeepak.mongo;

import com.github.spdeepak.mongo.entity.Details;
import com.github.spdeepak.mongo.entity.Project;
import com.github.spdeepak.mongo.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(final ProjectRepository projectRepository) {
        return args -> {
            Details details1 = Details.builder().description("Description one").key("key1").build();
            Details details2 = Details.builder().description("Description two").key("key1").build();
            Project project = Project.builder().name("First Project").details(List.of(details1, details2)).build();
            projectRepository.save(project);
        };
    }

}
