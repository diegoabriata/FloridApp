package com.floridApp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.floridApp.model.Sale;
import com.floridApp.model.SaleOrder;
import com.floridApp.service.BarrelService;
import com.floridApp.service.CustomerService;
import com.floridApp.service.SaleOrderService;
import com.floridApp.service.SaleService;

@Controller
@RequestMapping(value="/saleOrder")
public class SaleOrderController {
	
	@Autowired
	SaleService saleService;
	@Autowired
	CustomerService customerService;
	
	@Autowired
	BarrelService barrelService;
	
	@Autowired
	SaleOrderService saleOrderService; 

	@RequestMapping(value={"/saleOrderEdit"}, method = RequestMethod.GET)
	public String saleOrderEditForm(
			Model model, 
			@ModelAttribute("sale") final Sale sale, 
			BindingResult mapping1BindingResult) {
		
        model.addAttribute("barrels", barrelService.getAllBarrel());
        model.addAttribute("sales",sale);
        model.addAttribute("orders", saleOrderService.getAllSaleOrder());
		
		return "saleOrder/saleOrder_addOrUpdate";
	}
	
	
	
	
	
}
