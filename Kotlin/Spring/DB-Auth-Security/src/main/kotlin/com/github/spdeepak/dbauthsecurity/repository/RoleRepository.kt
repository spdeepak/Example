package com.github.spdeepak.dbauthsecurity.repository

import com.github.spdeepak.dbauthsecurity.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface RoleRepository : JpaRepository<Role, Long> {

    fun findByRolename(rolename: String): Role

}