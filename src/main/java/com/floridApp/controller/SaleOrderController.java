package com.floridApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.floridApp.service.BarrelService;
import com.floridApp.service.SaleOrderService;
import com.floridApp.service.SaleService;

@Controller
public class SaleOrderController {
	
	@Autowired
	SaleOrderService saleOrderService;
	@Autowired
	SaleService saleService;
	@Autowired
	BarrelService barrelService;
	
	
	public String barrelsList(Model model) {
		
		model.addAttribute("barrels", barrelService.getAllBarrel());
		model.addAttribute("orders", saleOrderService.getAllSaleOrder());
		return "orders";
	}
	
	
	
}
