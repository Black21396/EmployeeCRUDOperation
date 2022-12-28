package com.firstProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
// annotation to tell "jakarta" we want this class as Table in DB 
@Entity
// annotation to define the Table name in DB
@Table(name="employees")

public class Employee {
	/*
	 * define the primary key and make his value automatic*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	/*
	 * we have add getter and setter to send and receive the value for this table*/
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
