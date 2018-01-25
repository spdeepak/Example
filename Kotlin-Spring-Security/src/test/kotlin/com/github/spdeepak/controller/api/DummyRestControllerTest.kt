package com.github.spdeepak.controller.api

import io.restassured.RestAssured
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DummyRestControllerTest {

	@Test
	fun testStatusCode() {
		val jsonMimeType = "application/json"

		//RestAssured.port = 8080
		//RestAssured.baseURI = "http://localhost"
		RestAssured.given().auth().preemptive()
				.basic("spdeepak","spdeepak").contentType(jsonMimeType)
				.`when`().get("/api/test")
				.then()
				.statusCode(200)
				.body("First", Matchers.equalTo("First Text"))
				.body("Second",Matchers.equalTo("Second Text"))
				.body("Third",Matchers.equalTo("Third Text"))
	}
}