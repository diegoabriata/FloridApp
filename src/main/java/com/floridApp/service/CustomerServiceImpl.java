package com.floridApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floridApp.model.Customer;
import com.floridApp.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomer() {
		
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Customer customer) {
		
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		
		customerRepository.deleteById(id);
	}
	
}
