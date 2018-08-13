package com.floridApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.floridApp.model.Sale;

public interface SaleRepository extends CrudRepository<Sale, Long> {
	
}
