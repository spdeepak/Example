package com.github.spdeepak.controller.api

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Deepak Sunanda Prabhakar
 */
@RestController
@RequestMapping(value = "/api",produces = [MediaType.APPLICATION_JSON_VALUE])
open class DummyRestController {

	@GetMapping("/test")
	fun testSecurity(): Map<String,String> {
		var map = LinkedHashMap<String,String>()
		map.put("First","First Text")
		map.put("Second","Second Text")
		map.put("Third","Third Text")
		return map
	}
}