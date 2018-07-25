package com.floridApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.floridApp.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
