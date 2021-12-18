package com.github.spdeepak.dbauthsecurity.repository

import com.github.spdeepak.dbauthsecurity.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findOneByUserName(userName: String): User?

}