package com.github.spdeepak.repository

import com.github.spdeepak.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author Deepak Sunanda Prabhakar
 */
@Repository
interface UserRepository : JpaRepository<User, Long> {

	fun findOneByUserName(userName: String): User?

}