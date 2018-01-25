package com.github.spdeepak.entity

import java.util.*
import javax.persistence.*

/**
 * @author Deepak Sunanda Prabhakar
 */
@Entity
open class User(var firstName: String = "",
                var lastName: String = "",
                var userName: String = "",
                var email: String = "",
                var passWord: String = "") {

	@Id
	@GeneratedValue
	var id: Long? =null

	var version: Int = 0

	@Column( nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	var accountNonExpired: Boolean = true

	@Column( nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	var accountNonLocked: Boolean = true

	@Column( nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	var credentialsNonExpired: Boolean = true

	@Column( nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	var enabled: Boolean = true

	@OneToMany(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
	var roles: Set<Role> = HashSet()

	constructor(user: User) : this(user.firstName, user.lastName, user.userName, user.email, user.passWord) {
		id = user.id
		version = user.version
		firstName = user.firstName
		lastName = user.lastName
		userName = user.userName
		email = user.email
		passWord = user.passWord
		accountNonExpired = user.accountNonExpired
		accountNonLocked = user.accountNonLocked
		credentialsNonExpired = user.credentialsNonExpired
		enabled = user.enabled
		roles = user.roles
	}
}