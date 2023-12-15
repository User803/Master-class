package com.firstapp.customer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	private final ICustomerService customerService;	
	
	public CustomerController(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<Customer> getCustomers() {
		return customerService.getCustomers();		
	}	
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	Customer getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	void createCustomer(@RequestBody @Valid Customer customer) {
		System.out.println("POST request");
		System.out.println(customer);
	}
	
	@PutMapping(path = "{id}")
	@ResponseStatus(HttpStatus.OK)
	void updateCustomer(@RequestBody Customer customer,
						@PathVariable Long id) {
		
		System.out.println("PUT request");
		System.out.println(customer);
	}
	
	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteCustomer(@PathVariable Long id) {
		System.out.println("DELETE request");		
	}

}
