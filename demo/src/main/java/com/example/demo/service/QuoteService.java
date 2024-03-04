package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.ws.obj.Quote;

public class QuoteService {

	private List<Quote> quotes = new ArrayList<>();
	
	public QuoteService() {
		this.quotes.add(new Quote("You know 1", "abc"));
		this.quotes.add(new Quote("You know 2", "def"));
		this.quotes.add(new Quote("You know 3", "ghi"));
		this.quotes.add(new Quote("You know 4", "jkl"));
	}
	
	public Quote getQuote() {
		Random rn = new Random();
		int select = rn.nextInt(this.quotes.size());
		return this.quotes.get(select);
	}
	
	public void addQuote(Quote quote) {
		this.quotes.add(quote);
	}
	
}
