package com.firstapp.customer;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.firstapp.exceptions.NotFoundException;

@Service
public class CustomerService implements ICustomerService {
	
	private final static Logger log = 
			org.slf4j.LoggerFactory.getLogger(CustomerService.class);

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getCustomers() {
		log.info("get customers API");
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id)
					.orElseThrow(() -> {
							NotFoundException notFoundException = new NotFoundException("Customer with id " + id + " not found");
							log.error("error getting customer with id: {}", id, notFoundException);
							return notFoundException;
						});
	}

}
