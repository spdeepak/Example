package com.github.spdeepak.security.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping
    public ResponseEntity<String> dummyController() {
        return ResponseEntity.ok("This is the secured message");
    }

}
