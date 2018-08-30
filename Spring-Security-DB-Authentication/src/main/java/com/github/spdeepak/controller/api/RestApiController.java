package com.github.spdeepak.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping
    public ResponseEntity dummyController() {
        return new ResponseEntity<>("This is the secured message", HttpStatus.OK);
    }

}
