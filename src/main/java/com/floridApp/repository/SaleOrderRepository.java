package com.floridApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.floridApp.model.SaleOrder;

public interface SaleOrderRepository extends CrudRepository<SaleOrder, Long> {

}
