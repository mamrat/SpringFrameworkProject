package com.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springdatajpa.model.Book;

import jakarta.transaction.Transactional;

//can use for update/delete methods or entire interface
//will be wrapped in a transaction
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {
	
	//@Query("Select b from Book b where b.available = true")//alternate way next line
	@Query(value = "SELECT * FROM BOOK B WHERE B.AVAILABLE=1", nativeQuery = true)
	List<Book> findAvailableBooks();
	
	//Parameterised Query with positional parameters as 1, 2, 3...
	@Query("SELECT b FROM Book b where b.author=?1")
	List<Book> findByAuthor(String author);
	
	//namedParameters(with book entity class name and its parameters name used in query) - rather than using position and messing it up
	@Query("SELECT b FROM Book b WHERE b.author =:author and b.available=:available ORDER BY title")
	List<Book> findByAuthorAndAvailability(@Param("author")String author, @Param("available")boolean availability);
	
	@Modifying//query will modify the DB
	@Query("Update Book b set b.title=:title where b.bookId=:id")
	int updateTitleById(@Param("title")String title,@Param("id")Long id);
	
	@Modifying
	@Query("delete from Book b where b.title=?1")
	void deleteByTitle(String title);
	
	//Reference named queries from jpa-named-queries.properties file
	List<Book> findAllNamedQuery();
	
	List<Book> findByTitleNamedQuery(String title);
	
	@Query(nativeQuery = true)
	List<Book> findByAuthorNativeNamedQuery(@Param("author") String author);
	
}
