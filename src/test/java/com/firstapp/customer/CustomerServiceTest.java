package com.firstapp.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CustomerServiceTest {
	
	private CustomerService underTest;
	
	@Autowired
	private CustomerRepository customerRepository;

	@BeforeEach
	void setUp() throws Exception {
		underTest = new CustomerService(customerRepository);
		customerRepository.deleteAll();
	}

	@AfterEach
	void tearDown() throws Exception {
		customerRepository.deleteAll();
	}

	@Test
	void testGetCustomers() {
		// given
		Customer one = new Customer(
				 1L,
				"C1",
				"hello",
				"c1@gmail.com");
		
		Customer two = new Customer( 
				  2L,
				 "C2",
				 "hello",
				 "c2@gmail.com");		
		
		customerRepository.saveAll(List.of(one, two));
		
		// when		
		List<Customer> customers = underTest.getCustomers();
		
		// then
		assertEquals(2, customers.size());
	}

	@Test
	void testGetCustomer() {
		// given
		Customer one = new Customer(
				 1L,
				"C1",
				"hello",
				"c1@gmail.com");
		
		customerRepository.save(one);	
		
		// when
		Customer actual = underTest.getCustomer(1L);
		
		// then
		assertEquals(1L, actual.getId());
		assertEquals("C1", actual.getName());
		assertEquals("hello", actual.getPassword());
		assertEquals("c1@gmail.com", actual.getEmail());
	}

}
