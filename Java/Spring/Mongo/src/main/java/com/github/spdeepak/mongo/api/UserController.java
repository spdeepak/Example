package com.github.spdeepak.mongo.api;

import com.github.spdeepak.mongo.entity.User;
import com.github.spdeepak.mongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) {
        user = userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
