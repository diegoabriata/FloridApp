package com.floridApp.service;

import java.util.List;

import com.floridApp.model.*;

public interface CustomerService {
	
	public List<Customer> getAllCustomer();
	public Customer getCustomerById(Long id);
	public void saveOrUpdate(Customer customer);
	public void deleteCustomer(Long id);
	
}
