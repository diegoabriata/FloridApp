package com.floridApp.service;

import java.util.List;

import com.floridApp.model.SaleOrder;

public interface SaleOrderService {
	
	public List<SaleOrder> getAllSaleOrder();
	public SaleOrder getSaleOrderById(Long id);
	public void saveOrUpdate(SaleOrder saleOrder);
	public void deleteSaleOrder(Long id);
}
