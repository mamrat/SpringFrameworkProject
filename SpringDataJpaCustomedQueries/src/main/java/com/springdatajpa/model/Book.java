package com.springdatajpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	private String title;
	private String author;
	private int rating;
	private boolean available;
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", rating=" + rating
				+ ", available=" + available + "]";
	}
	
	public Book(String title, String author, int rating, boolean available) {
		super();
		this.title = title;
		this.author = author;
		this.rating = rating;
		this.available = available;
	}
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
