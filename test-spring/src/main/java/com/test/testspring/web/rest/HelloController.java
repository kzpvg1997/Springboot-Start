package com.test.testspring.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

	private final String HELLO_STATIC = "/hello";
	
	@GetMapping(HELLO_STATIC+"/test")
	public String index() {
		return "Hola bienvenido a Spring Boot!";
	}
}
