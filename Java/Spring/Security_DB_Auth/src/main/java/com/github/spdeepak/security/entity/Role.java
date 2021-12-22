package com.github.spdeepak.security.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String role;

}
