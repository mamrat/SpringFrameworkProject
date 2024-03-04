package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class RestTemplateApplication {

	private static final Logger log = LoggerFactory.getLogger(RestTemplate.class);
	
	public static void main(String args[]) {
		RestTemplate restTemplate = new RestTemplate();
		String quote = restTemplate.getForObject("http://localhost:8070", String.class); //executes request from specified url that is running locally
		log.info(quote.toString());
	}
	
}
