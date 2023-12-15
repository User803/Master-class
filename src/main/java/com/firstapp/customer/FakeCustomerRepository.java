package com.firstapp.customer;

import java.util.Arrays;
import java.util.List;

public class FakeCustomerRepository {
	
	public List<Customer> getCustomers() {
		return Arrays.asList(
				new Customer(1L, "Java 17","java@gmail.com", "pwd"),
				new Customer(2L, "Java 21","java@email.com", "PWD")
				);
	}

}

