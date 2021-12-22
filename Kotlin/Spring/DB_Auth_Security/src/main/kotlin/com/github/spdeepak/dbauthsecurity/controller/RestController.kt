package com.github.spdeepak.dbauthsecurity.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api"])
class RestController {

    @GetMapping
    fun testSecurity(): ResponseEntity<Map<String, String>> {
        val response = mapOf("First" to "First Text", "Second" to "Second Text", "Third" to "Third Text")
        return ResponseEntity.ok(response)
    }

}
