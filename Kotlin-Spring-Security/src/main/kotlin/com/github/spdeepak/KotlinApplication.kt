package com.github.spdeepak

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @author Deepak Sunanda Prabhakar
 */
@SpringBootApplication
open class KotlinApplication

fun main(args: Array<String>) {
	SpringApplication.run(KotlinApplication::class.java, * args)
}
