package com.floridApp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floridApp.model.SaleOrder;
import com.floridApp.repository.SaleOrderRepository;

@Service
@Transactional
public class SaleOrderServiceImpl implements SaleOrderService {
	
	@Autowired
	SaleOrderRepository saleOrderRepository;
	
	@Override
	public List<SaleOrder> getAllSaleOrder() {
		
		return (List<SaleOrder>) saleOrderRepository.findAll();
	}

	@Override
	public SaleOrder getSaleOrderById(Long id) {
		
		return saleOrderRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(SaleOrder saleOrder) {
		saleOrderRepository.save(saleOrder);
	}

	@Override
	public void deleteSaleOrder(Long id) {
		
		saleOrderRepository.deleteById(id);
	}

}
