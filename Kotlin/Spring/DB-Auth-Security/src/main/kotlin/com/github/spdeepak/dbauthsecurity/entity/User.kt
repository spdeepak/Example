package com.github.spdeepak.dbauthsecurity.entity

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany


data class User(
    @Id @GeneratedValue var id: Long,
    @Column(nullable = false) var firstName: String,
    @Column(nullable = false) var lastName: String,
    @Column(nullable = false) var userName: String,
    @Column(nullable = false) var email: String,
    @Column(nullable = false) var password: String,
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true") var accountNonExpired: Boolean,
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true") var accountNonLocked: Boolean,
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true") var credentialsNonExpired: Boolean,
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true") var enabled: Boolean,
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL]) var roles: Set<Role>
)
