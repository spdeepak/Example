package com.deepaksp.mongodbdemo;

import com.deepaksp.mongodbdemo.entity.Details;
import com.deepaksp.mongodbdemo.entity.Project;
import com.deepaksp.mongodbdemo.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MongodbdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbdemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(final ProjectRepository projectRepository) {
        return args -> {
            Project project = Project.builder()
                    .name("First Project")
                    .details(List.of(
                            Details.builder()
                                    .description("Description one")
                                    .key("key1")
                                    .build(),
                            Details.builder()
                                    .description("Description two")
                                    .key("key1")
                                    .build()
                    ))
                    .build();
            projectRepository.save(project);
        };
    }
}
