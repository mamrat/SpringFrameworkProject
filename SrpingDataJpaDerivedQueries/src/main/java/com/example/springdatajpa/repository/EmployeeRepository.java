package com.example.springdatajpa.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.springdatajpa.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{//corres. class and Datatype of PK{

	//spring looks for findbyemail =search by email column
	Employee findByEmail(String email);
	List<Employee> findByName(String name);
	
	//optional findByEmail
	//Optional<Employee> findByEmail(String email);
	
	//Optional<List<Employee>> findByName(String name);
	
	
	
	////**********DERIVERD QUERY METHODS*********
	List<Employee> findByNameOrEmail(String name, String email);
	List<Employee> findByNameAndLevel(String name, int level);
	
	List<Employee> findByNameIs(String name);
	List<Employee> findByNameEquals(String name);
	
	List<Employee> findByNameIsNot(String name);
	
	List<Employee> findByNameStartsWith(String prefix);
	
	List<Employee> findByNameEndsWith(String suffix);
	
	List<Employee> findByNameIgnoreCase(String name);
	
	List<Employee> findByNameLike(String pattern);
	
	Employee findFirstByName(String name);
	
	Employee findFirstByNameOrderByLevelAsc(String name);
	
	List<Employee> findByEmailContaining(String infix);//sub-string search
	
	Employee findFirstByOrderByEmail();
	
	
	
	List<Employee> findByLevelLessThan(int level);
    List<Employee> findByLevelLessThanEqual(int level);

    List<Employee> findByLevelGreaterThan(int level);
    List<Employee> findFirst2ByLevelOrderByBirthDateDesc (int level);

    List<Employee> findByBirthDateBefore(Date before);
    List<Employee> findByBirthDateAfter(Date after);
    List<Employee> findByBirthDateBetween(Date start, Date end);

    Employee findTopByOrderByBirthDateDesc();
	
	
}
