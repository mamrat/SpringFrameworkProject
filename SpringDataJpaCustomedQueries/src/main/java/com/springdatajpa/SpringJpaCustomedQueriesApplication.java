package com.springdatajpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springdatajpa.model.Book;
import com.springdatajpa.repository.BookRepository;

@SpringBootApplication
public class SpringJpaCustomedQueriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaCustomedQueriesApplication.class, args);
	}
	
	@Bean
	  public CommandLineRunner demo(BookRepository bookRepository) {
	    return (args) -> {
	    	
	    	//initial save
	    	/*bookRepository.save(new Book("The Tunnel", "William", 4, false));
	    	bookRepository.save(new Book("The Holy", "James", 8, true));
	    	bookRepository.save(new Book("Winter Snow", "John", 9, true));
	    	bookRepository.save(new Book("Shri Ram", "Guru", 10, true));
	    	bookRepository.save(new Book("Laugh", "Ash", 8, false));*/
	    	
	    	//*********CUSTOM QUERIES************
	    	System.out.println("\n*****************************");
	    	System.out.println("\nQuerying for available book...");
	    	
	    	List<Book> availableBooks = bookRepository.findAvailableBooks();
	    	System.out.println("\n OUTPUT:\n"+availableBooks.toString());
	    	System.out.println("\n*****************************");
	    	
	    	System.out.println("\nfindByAuthor...");
	    	
	    	List<Book> books = bookRepository.findByAuthor("guru");
	    	System.out.println("\n OUTPUT:\n"+books.toString());
	    	System.out.println("\n*****************************");
	    	
	    	System.out.println("\nfindByAuthorAndAvailability...");
	    	
	    	books = bookRepository.findByAuthorAndAvailability("guru", true);
	    	System.out.println("\n OUTPUT:\n"+books.toString());
	    	System.out.println("\n*****************************");
	    	
            System.out.println("\nupdateTitleById...");
	    	
	    	int book = bookRepository.updateTitleById("Atomic habits", 5L);
	    	System.out.println("\n OUTPUT:\n"+book);
	    	System.out.println("\n*****************************");
	    	
	    	

	    	System.out.println("\nfindByAuthor...");
	    	
	    	books = bookRepository.findByAuthor("ash");
	    	System.out.println("\n OUTPUT:\n"+books.toString());
	    	System.out.println("\n*****************************");
	    	
	    	
	    	System.out.println("\ndeleteByTitle...");
	    	
	    	bookRepository.deleteByTitle("The Tunnel");
	    	System.out.println("\n All books in store.......");
	    	for(Book b : bookRepository.findAll()) {
	    		System.out.println("\n OUTPUT:\n"+b.toString());
	    	}
	    	System.out.println("\n*****************************");
	    	
	    	
	    	
	    	
	    	///******NAMED QUERIES*******
	    	
	    	System.out.println("\nRetrieving all books...");
	    	
	    	books = bookRepository.findAllNamedQuery();
	    	System.out.println("\n OUTPUT:\n"+books.toString());
	    	System.out.println("\n*****************************");
	    	
	    	System.out.println("\nRetrieving all books by title...");
	    	
	    	books = bookRepository.findByTitleNamedQuery("The Holy");
	    	System.out.println("\n OUTPUT:\n"+books.toString());
	    	System.out.println("\n*****************************");    	
	
	    	System.out.println("\nRetrieving all books by author...");
	    	
	    	books = bookRepository.findByAuthorNativeNamedQuery("guru");
	    	System.out.println("\n OUTPUT:\n"+books.toString());
	    	System.out.println("\n*****************************");
	    	
	    	
	    };
	  }
	    	

}
