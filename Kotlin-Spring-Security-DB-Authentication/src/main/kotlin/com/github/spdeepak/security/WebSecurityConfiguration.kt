package com.github.spdeepak.security

import com.github.spdeepak.security.handler.RefererRedirectionAuthenticationSuccessHandler
import com.github.spdeepak.security.service.CustomUserDetailsService
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

/**
 * @author Deepak Sunanda Prabhakar
 */
@EnableWebSecurity
open class WebSecurityConfiguration(private val customUserDetailsService: CustomUserDetailsService,
                                    private val passwordEncoderAndMatcher: PasswordEncoder,
                                    private val refererRedirectionAuthenticationSuccessHandler: RefererRedirectionAuthenticationSuccessHandler)
	: WebSecurityConfigurerAdapter() {

	override fun configure(http: HttpSecurity) {
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/api/*").authenticated()
				.and()
				.httpBasic() //This line will enable Basic Authentication as well. It can be used to access REST API from Postman using Basic Authentication
				.and()
				.exceptionHandling().accessDeniedPage("/error")//Access denied page settings
				.and()
				.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").failureUrl("/login?error")
				.successHandler(refererRedirectionAuthenticationSuccessHandler) //This line will help in redirection to the URL which the user tried to access before login
				.defaultSuccessUrl("/api/test") //This line will help in redirection to the default success URL
				.and()
				.logout().logoutRequestMatcher(AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
				.and().csrf()
				.and().exceptionHandling().accessDeniedPage("/access_denied")
	}

	override fun configure(auth: AuthenticationManagerBuilder) {
		auth.userDetailsService(customUserDetailsService)
				.passwordEncoder(passwordEncoderAndMatcher)
	}
}