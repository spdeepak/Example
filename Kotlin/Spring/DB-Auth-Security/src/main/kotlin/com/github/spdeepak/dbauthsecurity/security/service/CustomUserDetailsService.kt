package com.github.spdeepak.dbauthsecurity.security.service

import com.github.spdeepak.dbauthsecurity.repository.UserRepository
import com.github.spdeepak.dbauthsecurity.security.CustomUserDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service


@Service
class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return CustomUserDetails(userRepository.findOneByUserName(username)!!)
    }

}