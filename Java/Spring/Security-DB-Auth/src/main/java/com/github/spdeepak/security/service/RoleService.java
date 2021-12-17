package com.github.spdeepak.security.service;

import com.github.spdeepak.security.entity.Role;
import com.github.spdeepak.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }

}
