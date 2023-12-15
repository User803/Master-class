package com.firstapp.customer;

import java.util.List;

public interface ICustomerService {
	
	List<Customer> getCustomers();

	Customer getCustomer(Long id);

}
