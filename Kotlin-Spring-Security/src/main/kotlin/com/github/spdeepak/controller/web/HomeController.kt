package com.github.spdeepak.controller.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
open class HomeController {

	@GetMapping("/")
	fun indexPage(): String {
		return "index"
	}

	@GetMapping("/login")
	fun loginPage(): String {
		return "login"
	}

	@GetMapping("/error")
	fun accessDeniedPage(): String {
		return "/403"
	}

}