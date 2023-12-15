package com.firstapp.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "customer")
@Table
public class Customer {
	
	@Id
	private Long id;
	
	@NotBlank(message = "*Required")
	private String name;
		
	@NotBlank(message = "*Required")
	@JsonProperty(access = Access.WRITE_ONLY)
	// Allows for ability to send this property in a POST request 
	// but is ignored when fetching the object i.e GET request
	private String password;
	
	@NotBlank(message = "*Required")
	@Email
	private String email;	
	
	public Customer() { }

	public Customer(Long id, String name,
					String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}

}