package com.github.spdeepak.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class User {

    @Id
    private String Id;

    private String firstName;

    private String middleName;

    private String lastName;

    private Date dateOfBirth;
}
