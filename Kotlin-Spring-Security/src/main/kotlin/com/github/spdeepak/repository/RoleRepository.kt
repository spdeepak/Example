package com.github.spdeepak.repository

import com.github.spdeepak.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author Deepak Sunanda Prabhakar
 */
@Repository
interface RoleRepository : JpaRepository<Role, Long> {

	fun findByRolename(rolename: String): Role

}