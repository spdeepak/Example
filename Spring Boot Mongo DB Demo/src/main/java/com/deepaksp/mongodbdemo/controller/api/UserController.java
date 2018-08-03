package com.deepaksp.mongodbdemo.controller.api;

import com.deepaksp.mongodbdemo.entity.User;
import com.deepaksp.mongodbdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody User user) {
        user = userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(users, HttpStatus.FOUND);
    }

}
