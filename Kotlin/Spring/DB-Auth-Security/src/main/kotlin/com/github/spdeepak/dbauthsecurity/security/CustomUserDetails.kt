package com.github.spdeepak.dbauthsecurity.security

import com.github.spdeepak.dbauthsecurity.entity.User
import org.slf4j.LoggerFactory
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

class CustomUserDetails(private val user: User) : UserDetails {

    private val log = LoggerFactory.getLogger(CustomUserDetails::class.java)

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return user.roles.stream().map { role ->
            log.debug("Granting Authority to user with role: $role")
            SimpleGrantedAuthority(role.toString())
        }.collect(Collectors.toList())
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getUsername(): String {
        return user.userName
    }

    override fun isEnabled(): Boolean {
        return user.enabled
    }

    override fun isCredentialsNonExpired(): Boolean {
        return user.credentialsNonExpired
    }

    override fun isAccountNonExpired(): Boolean {
        return user.accountNonExpired
    }

    override fun isAccountNonLocked(): Boolean {
        return user.accountNonLocked
    }

}
