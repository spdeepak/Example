package com.github.spdeepak.security.ui;

import com.github.spdeepak.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/api/**").authenticated()
				.anyRequest().permitAll()
				.and()
				.httpBasic() //This line will enable Basic Authentication as well. It can be used to access REST API from Postman using Basic Authentication
				.and()
				.formLogin().permitAll().failureUrl("/login?error")
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("logout")).logoutSuccessUrl("/login")
				.and().csrf();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService)
				.passwordEncoder(getPasswordEncoder());
	}

	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {

			@Override
			public String encode(final CharSequence rawPassword) {
				return passwordEncoder.encode(rawPassword);
			}

			@Override
			public boolean matches(final CharSequence rawPassword, final String encodedPassword) {
				return passwordEncoder.matches(rawPassword, encodedPassword);
			}
		};
	}

}