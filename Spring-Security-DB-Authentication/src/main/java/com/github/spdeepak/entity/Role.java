package com.github.spdeepak.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String Role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
