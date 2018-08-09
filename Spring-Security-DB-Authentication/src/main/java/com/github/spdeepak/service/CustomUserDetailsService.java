package com.github.spdeepak.service;

import com.github.spdeepak.entity.User;
import com.github.spdeepak.repository.UserRepository;
import com.github.spdeepak.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByUsername(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUser.map(CustomUserDetails::new).get();
	}
}
