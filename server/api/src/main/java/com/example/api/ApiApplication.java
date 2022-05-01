package com.example.api;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@RequestMapping("/jsonTest")
	public Map<String, String> jsonTest(){

		return Collections.singletonMap("message", "Hello, World!");
	}

}
