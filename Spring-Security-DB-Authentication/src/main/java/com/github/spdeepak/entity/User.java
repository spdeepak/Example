package com.github.spdeepak.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int version;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private boolean accountNonExpired;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private boolean accountNonLocked;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private boolean credentialsNonExpired;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private boolean enabled;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @ManyToMany
    private Set<Role> roles;

    protected User(User user) {
        id = user.getId();
        username = user.getUsername();
        roles = user.getRoles();
        password = user.getPassword();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        accountNonExpired = user.isAccountNonExpired();
        accountNonLocked = user.isAccountNonLocked();
        credentialsNonExpired = user.isCredentialsNonExpired();
        enabled = user.isEnabled();
    }

}
