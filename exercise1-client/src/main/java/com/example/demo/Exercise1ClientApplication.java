package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Exercise1ClientApplication {

	private static final Logger log = LoggerFactory.getLogger(Exercise1ClientApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Exercise1ClientApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();
		String echo = restTemplate.postForObject("http://localhost:8080/echo", "foo", String.class);
		log.info(echo);
	}

}
