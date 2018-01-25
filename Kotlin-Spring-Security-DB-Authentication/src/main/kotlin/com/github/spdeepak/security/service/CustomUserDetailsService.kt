package com.github.spdeepak.security.service

import com.github.spdeepak.repository.UserRepository
import com.github.spdeepak.security.CustomUserDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

/**
 * @author Deepak Sunanda Prabhakar
 */
@Service
open class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

	override fun loadUserByUsername(username: String): UserDetails {
		return CustomUserDetails(userRepository.findOneByUserName(username)!!)
	}

}