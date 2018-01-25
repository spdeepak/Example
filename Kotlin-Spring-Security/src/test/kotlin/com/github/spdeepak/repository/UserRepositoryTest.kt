package com.github.spdeepak.repository

import com.github.spdeepak.entity.Role
import com.github.spdeepak.entity.User
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals

/**
 * @author Deepak Sunanda Prabhakar
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class UserRepositoryTest {

	@Autowired
	lateinit var userRepository: UserRepository

	@Before
	fun addUser() {
		val user = User("Deepak", "SP", "speedpak1991@gmail.com", "speedpak1991@gmail.com", "deepaksp")
		var roles: Set<Role> = setOf(Role("ROLE_ADMIN"))
		user.roles = roles
		userRepository.save(user)
	}

	@Test
	fun testUserSave() {
		val user = userRepository.findOneByUserName("speedpak1991@gmail.com")
		assertEquals("Deepak", "${user!!.firstName}")
		assertEquals("SP", "${user!!.lastName}")
		assertEquals("speedpak1991@gmail.com", "${user!!.email}")
		assertEquals("deepaksp", "${user!!.passWord}")
	}

}
