package com.firstProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
