package com.floridApp.service;

import java.util.Set;

import com.floridApp.model.SaleOrder;

public interface SaleOrderService {
	
	public Set<SaleOrder> getAllSaleOrder();
	public SaleOrder getSaleOrderById(Long id);
	public void saveOrUpdate(SaleOrder saleOrder);
	public void deleteSaleOrder(Long id);
}
