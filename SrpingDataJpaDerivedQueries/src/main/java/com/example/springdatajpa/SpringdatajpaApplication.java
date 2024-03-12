package com.example.springdatajpa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springdatajpa.model.Employee;
import com.example.springdatajpa.repository.EmployeeRepository;

@SpringBootApplication
public class SpringdatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}
	
	@Bean
	  public CommandLineRunner demo(EmployeeRepository employeeRepository) {
	    return (args) -> {
	    	
	    	/*employeeRepository.save(new Employee(1L, "Ashish", "ashish10@gmail.com"));
			employeeRepository.save(new Employee(2L,"Anil", "anil50@gmail.com"));
			employeeRepository.save(new Employee(3L,"John", "john40@gmail.com"));
			employeeRepository.save(new Employee(4L,"Mamtha", "mamtha80@gmail.com"));
			employeeRepository.save(new Employee(5L, "ajay", "ajay60@gmail.com"));
			employeeRepository.save(new Employee(6L, "ajay", "ajay70@gmail.com"));*/
			
	    	//3.using derived query
	    	/*System.out.println("*\n*****************");
	    	System.out.println("\n Retrieving all employee data...\n");
	    	for(Employee em : employeeRepository.findAll()) {
	    		System.out.println(em.toString());
	    	}
	    	System.out.println("*\n*****************");
	    
	    	System.out.println("*\n*****************");
	    	System.out.println("\n Retrieving one employee data...\n");
	    	Employee em = employeeRepository.findById(2L).get();
	    	System.out.println(em.toString());
	    	System.out.println("*\n*****************");
	    	
	    	
	    	System.out.println("*\n*****************");
	    	System.out.println("\n Retrieving one employee data by email...\n");
	    	Optional<Employee> empByEmail = employeeRepository.findByEmail("anil50@gmail.com");
	    	System.out.println(empByEmail.toString());
	    	System.out.println("*\n*****************");
	    	
	    	System.out.println("*\n*****************");
	    	System.out.println("\n Delete one employee data by email...\n");
	    	Employee emplEmail = employeeRepository.findByEmail("ajay60@gmail.com").get();
	    	employeeRepository.delete(emplEmail);
	    	
	    	employeeRepository.deleteById(102L);
	    	
	    	
	    	System.out.println("*\n*****************");
	    	System.out.println("\n Retrieving one employee data by name...\n");
	    	Optional<List<Employee>> empByName = employeeRepository.findByName("ajay");
	    	System.out.println(empByName.toString());
	    	System.out.println("*\n*****************");
	    	
	    	//optional type
	    	System.out.println("*\n*****************");
	    	System.out.println("\n Retrieving one employee without matching record(may or may not)...\n");
	    	Optional<List<Employee>> emplByName = employeeRepository.findByName("ash");
	    	System.out.println(emplByName.toString());
	    	System.out.println("*\n*****************");
	    	
	    	//Optional
	    	/*Optional<Employee> emplByEmail = employeeRepository.findByEmail("ash77@gmail.com");
	    	
	    	if(emplByEmail.isPresent()) {
	    		Employee retrievedEmail = emplByEmail.get();
	    		retrievedEmail.setEmail("ash77@gmail.com");
	    		
	    		employeeRepository.save(retrievedEmail);//save will save does not exists else update
	    		
	    		System.out.println("*\n*****************");
		    	System.out.println("\n Retrieving one employee data by email...\n");
		    	System.out.println(retrievedEmail.toString());
		    	System.out.println("*\n*****************");
	    	}*/
	    	
	    	//employeeRepository.deleteAll();
	    	
	    	//save all details of emp with level and date fields
	    	
	    	/*employeeRepository.save(new Employee(1L, "Ashish", "ashish10@gmail.com", 3, 
	    			new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2000")));
			employeeRepository.save(new Employee(2L,"Anil", "anil50@gmail.com", 4,
					new SimpleDateFormat("dd/MM/yyyy").parse("1/2/2002")));
			employeeRepository.save(new Employee(3L,"John", "john40@gmail.com", 1,
					new SimpleDateFormat("dd/MM/yyyy").parse("22/05/1998")));
			employeeRepository.save(new Employee(4L,"Mamtha", "mamtha80@gmail.com", 3,
					new SimpleDateFormat("dd/MM/yyyy").parse("17/04/1997")));
			employeeRepository.save(new Employee(5L, "ajay", "ajay60@gmail.com",3,
					new SimpleDateFormat("dd/MM/yyyy").parse("04/09/1996")));
			employeeRepository.save(new Employee(6L, "ajay", "ajay70@gmail.com", 2,
					new SimpleDateFormat("dd/MM/yyyy").parse("30/03/1999")));
			*/
			
	    	
	    	//**********DERIVERD QUERY METHODS*********
			/*System.out.println("*\n*****************");
	    	System.out.println("\n Both name and email match......\n");
	    	List<Employee> empByNameOrEmail = employeeRepository.findByNameOrEmail("anil", "anil50@gmail.com");
	    	System.out.println(empByNameOrEmail.toString());
	    	
	    	System.out.println("\n only name match......\n");
	    	empByNameOrEmail = employeeRepository.findByNameOrEmail("anil", "anil@gmail.com");
	    	System.out.println(empByNameOrEmail.toString());
	    	
	    	System.out.println("\n only email match......\n");
	    	empByNameOrEmail = employeeRepository.findByNameOrEmail("ani", "anil50@gmail.com");
	    	System.out.println(empByNameOrEmail.toString());
	    	
	    	System.out.println("\n name and email dont match......\n");
	    	empByNameOrEmail = employeeRepository.findByNameOrEmail("ani", "anil@gmail.com");
	    	System.out.println(empByNameOrEmail.toString());
	    	
	    	System.out.println("\n name and email of different employees......\n");
	    	empByNameOrEmail = employeeRepository.findByNameOrEmail("mamtha", "john40@gmail.com");
	    	System.out.println(empByNameOrEmail.toString());
	    	
	    	System.out.println("*\n*****************");
	    	
	    	
	    	
	    	
	    	
			System.out.println("*\n*****************");
	    	System.out.println("\n Both name and level match 1 employee......\n");
	    	List<Employee> empByNameAndLevel = employeeRepository.findByNameAndLevel("anil", 4);
	    	System.out.println(empByNameAndLevel.toString());
	    	
	    	System.out.println("\n Both name and level match 0 employee......\n");
	    	empByNameAndLevel = employeeRepository.findByNameAndLevel("anil", 3);
	    	System.out.println(empByNameAndLevel.toString());
	    	
	    	
	    	System.out.println("\n findByName......\n");
	    	List<Employee> findByName = employeeRepository.findByName("John");
	    	System.out.println(findByName.toString());
	    	
	    	System.out.println("\n findByNameIs......\n");
	    	findByName = employeeRepository.findByNameIs("John");
	    	System.out.println(findByName.toString());
	    	
	    	System.out.println("\n findByNameEquals......\n");
	    	findByName = employeeRepository.findByNameEquals("John");
	    	System.out.println(findByName.toString());
	    	
	    	System.out.println("\n findByNameIsNot......\n");
	    	List<Employee> findByNameIsNot = employeeRepository.findByNameIsNot("John");
	    	System.out.println(findByNameIsNot.toString());
	    	
	    	System.out.println("*\n*****************");
	    	
	    	
	    	
	    	
	    	System.out.println("*\n*****************");
	    	System.out.println("\n findByNameStartsWith......\n");
	    	List<Employee> empsByName = employeeRepository.findByNameStartsWith("a");
	    	System.out.println(empsByName.toString());
	    	
	    	System.out.println("\n findByNameEndsWith......\n");
	    	empsByName = employeeRepository.findByNameEndsWith("tha");
	    	System.out.println(empsByName.toString());
	    	
	    	System.out.println("\n findByNameIgnoreCase......\n");
	    	empsByName = employeeRepository.findByNameIgnoreCase("mAMTHA");
	    	System.out.println(empsByName.toString());
	    	
	    	System.out.println("\n findByNameLike......\n");
	    	empsByName = employeeRepository.findByNameLike("%aj%");
	    	System.out.println(empsByName.toString());
	    	
	    	System.out.println("\n findFirstByName......\n");
	    	Employee empByName = employeeRepository.findFirstByName("ajay");
	    	System.out.println(empByName.toString());
	    	
	    	System.out.println("\n findFirstByNameOrderByLevelAsc......\n");
	    	empByName = employeeRepository.findFirstByNameOrderByLevelAsc("ajay");
	    	System.out.println(empByName.toString());
	    	
	    	System.out.println("\n findByEmailContaining......\n");
	    	List<Employee> empsByEmail = employeeRepository.findByEmailContaining("i");
	    	System.out.println(empsByEmail.toString());
	    	
	    	System.out.println("\n findFirstByOrderByEmail......\n");
	    	Employee empByEmail = employeeRepository.findFirstByOrderByEmail();
	    	System.out.println(empByEmail.toString());
	    	
	    	System.out.println("*\n*****************");
	    	
	    	
	    	
	    	
	    	System.out.println("\n**************************");
			System.out.println("\nRetrieving Employees by level");

			System.out.println("\nfindByLevelLessThan");
			List<Employee> emps = employeeRepository.findByLevelLessThan(3);
			System.out.println("Returned data: " + emps.toString());

			System.out.println("\nfindByLevelLessThanEqual");
			emps = employeeRepository.findByLevelLessThanEqual(3);
			System.out.println("Returned data: " + emps.toString());

			System.out.println("\nfindByLevelGreaterThan");
			emps = employeeRepository.findByLevelGreaterThan(3);
			System.out.println("Returned data: " + emps.toString());

			System.out.println("\nfindFirst2ByLevelOrderByBirthDateDesc");
			emps = employeeRepository.findFirst2ByLevelOrderByBirthDateDesc(3);
			System.out.println("Returned data: " + emps.toString());


			System.out.println("\n**************************");
			System.out.println("\nRetrieving Employees by birth date");

			Date refDate = new SimpleDateFormat("dd/MM/yyyy").parse("22/05/1998");

			System.out.println("\nfindByBirthDateBefore");
			emps = employeeRepository.findByBirthDateBefore(refDate);
			System.out.println("Returned data: " + emps.toString());

			System.out.println("\nfindByBirthDateAfter");
			emps = employeeRepository.findByBirthDateAfter(refDate);
			System.out.println("Returned data: " + emps.toString());

			System.out.println("\nfindByBirthDateBetween");
			Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse("04/09/1996");
			emps = employeeRepository.findByBirthDateBetween(startDate, refDate);
			System.out.println("Returned data: " + emps.toString());

			System.out.println("\nfindTopByOrderByBirthDateDesc");
			Employee emp = employeeRepository.findTopByOrderByBirthDateDesc();
			System.out.println("Returned data: " + emp.toString());*/
	    	
	    };
	    
	}

}
