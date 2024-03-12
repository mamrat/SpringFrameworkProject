package com.example.springdatajpa.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	
	private int level;
	private Date birthDate;
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Employee(Long id, String name, String email, int level, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.level = level;
		this.birthDate = birthDate;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", level=" + level + ", birthDate="
				+ birthDate + "]";
	}

}
