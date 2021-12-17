package com.github.spdeepak.security.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.spdeepak.security.entity.User;
import com.github.spdeepak.security.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    public CustomUserDetailsService customUserDetailsService;

    @Test
    void loadUserByUsername() throws IOException {
        User user = new ObjectMapper().readValue(getClass().getClassLoader().getResource("user.json"), User.class);
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(user));

        UserDetails userDetails = customUserDetailsService.loadUserByUsername("username");
        Assertions.assertThat(userDetails)
                .isNotNull()
                .hasFieldOrPropertyWithValue("accountNonExpired", true)
                .hasFieldOrPropertyWithValue("accountNonLocked", true)
                .hasFieldOrPropertyWithValue("credentialsNonExpired", true)
                .hasFieldOrPropertyWithValue("enabled", true)
                .hasFieldOrPropertyWithValue("password", "passwordofusername")
                .hasFieldOrPropertyWithValue("username", "username");
    }

}
