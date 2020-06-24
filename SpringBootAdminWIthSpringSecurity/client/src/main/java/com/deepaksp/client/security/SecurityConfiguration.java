package com.deepaksp.client.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//		log.info("Password: {}", encoder.encode("admin"));
		auth.inMemoryAuthentication()
				//				.passwordEncoder(encoder)
				.withUser("admin")
				.password("admin")
				.authorities("admin");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
				.disable()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/actuator", "/actuator/**", "/")
				.permitAll()
				.anyRequest()
				.authenticated();
	}
}
