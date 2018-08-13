package com.floridApp.service;

import java.util.List;

import com.floridApp.model.Sale;

public interface SaleService {

	public List<Sale> getAllSale();
	public Sale getSaleById(Long id);
	public void saveOrUpdate(Sale sale);
	public void deleteSale(Long id);
}
