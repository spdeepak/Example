package com.github.spdeepak.mongo;

import com.github.spdeepak.mongo.entity.Project;
import com.github.spdeepak.mongo.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(final ProjectRepository projectRepository) {
        return args -> {
            Project project = Project.builder().name("First Project").build();
            projectRepository.save(project);
        };
    }

}
