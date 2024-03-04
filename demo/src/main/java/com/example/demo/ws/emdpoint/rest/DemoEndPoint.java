package com.example.demo.ws.emdpoint.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.QuoteService;
import com.example.demo.ws.obj.Quote;

@RestController
public class DemoEndPoint {
	//spring boot services
	/*private RestTemplate template;
	
	public DemoEndPoint(RestTemplate template) {
		this.template = template;
	}//spring boot services

	@RequestMapping("/hello")
	public String helloWorld() {
		return "helo world";
	}
	
	@RequestMapping("/other")
	public String other() {
		return "other is working";
	}*/
	
	//springboot services
	/*@RequestMapping("/template")
	public String hello() {
		String message = this.template.getForObject("http://localhost:8070", String.class);
		return message;
	}*///spring boot services
	
	
	//spring with restfull webservice
	
	private QuoteService quoteService;
	
	public DemoEndPoint(QuoteService quoteService) {
		this.quoteService = quoteService;
	}
	
	@RequestMapping("/quote")
	public Quote getQuote() {
		return this.quoteService.getQuote();
	}
	//spring with restfull webservice
	
	
	
	//sprint rest controller
	@RequestMapping(value = "/quote", method = RequestMethod.POST)
	public void addQuote(@RequestBody Quote quote) {
		this.quoteService.addQuote(quote);
	}
	
	//spring devtools
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello world";
	}
	
	
}
