package com.floridApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floridApp.model.Sale;
import com.floridApp.repository.SaleRepository;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	SaleRepository saleRepository;
	
	@Override
	public List<Sale> getAllSale() {
		return (List<Sale>) saleRepository.findAll();
	}

	@Override
	public Sale getSaleById(Long id) {
		
		return saleRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Sale sale) {
		
		saleRepository.save(sale);
	}

	@Override
	public void deleteSale(Long id) {
		
		saleRepository.deleteById(id);
	}

}
