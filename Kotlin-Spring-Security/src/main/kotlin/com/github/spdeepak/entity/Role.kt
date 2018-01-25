package com.github.spdeepak.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @author Deepak Sunanda Prabhakar
 */
@Entity
data class Role(var rolename: String = "") {

	@Id
	@GeneratedValue
	val id: Long? = null

}