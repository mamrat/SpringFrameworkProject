package com.example.demo;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.QuoteService;
import com.example.demo.ws.obj.Quote;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	QuoteService quoteService;
	
	@Before //executed when we write the test
	public void before() {
		this.quoteService = new QuoteService();
	}
	
	@Test
	public void testGetQuote() {
		this.quoteService.addQuote(new Quote("ABC", "D"));
		assertEquals("ABC", this.quoteService.getQuote().getValue());
	}
	
	@Test
	public void testGetQuoteMultiple() {
		this.quoteService.addQuote(new Quote("ABC", "D"));
		this.quoteService.addQuote(new Quote("EFG", "H"));
		assertTrue("ABC".equals(this.quoteService.getQuote().getValue()) || 
		"EFG".equals(this.quoteService.getQuote().getValue()));
	}

}
