package com.github.spdeepak.dbauthsecurity.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Role(
    @Id
    @GeneratedValue
    val id: Long,
    var rolename: String
)
