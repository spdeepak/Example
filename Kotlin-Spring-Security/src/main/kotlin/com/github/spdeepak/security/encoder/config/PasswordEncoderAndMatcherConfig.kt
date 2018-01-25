package com.github.spdeepak.security.encoder.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * @author Deepak Sunanda Prabhakar
 */
@Configuration
open class PasswordEncoderAndMatcherConfig {

	@Bean
	open fun passwordEncoderAndMatcher(): PasswordEncoder {
		return object : PasswordEncoder {
			override fun encode(rawPassword: CharSequence?): String {
				return BCryptPasswordEncoder().encode(rawPassword)
			}

			override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
				return BCryptPasswordEncoder().matches(rawPassword, encodedPassword)
			}
		}
	}
}