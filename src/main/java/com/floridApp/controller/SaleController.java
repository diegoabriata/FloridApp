package com.floridApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.floridApp.model.Sale;
import com.floridApp.service.CustomerService;
import com.floridApp.service.SaleService;

@Controller
@RequestMapping(value="/sale")
public class SaleController {
	
	@Autowired
	SaleService saleService;
	@Autowired
	CustomerService customerService;

	@RequestMapping(value= {"/","/list"}, method=RequestMethod.GET)
	public String saleList( Model model) {
		model.addAttribute("saleList", saleService.getAllSale());		
		return "sale/sale_list";
	}

	@RequestMapping(value={"/saleEdit","/saleEdit/{id}"}, method = RequestMethod.GET)
	public String saleEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
		
		if (null != id) {
			model.addAttribute("sale", saleService.getSaleById(id));
		} else {
			model.addAttribute("sale", new Sale());
		}
		model.addAttribute("customerSale", customerService.getAllCustomer());

		return "sale/sale_addOrUpdate";
	}
	@RequestMapping(value={"/saleEdit"}, method = RequestMethod.POST)
	public String saleEdit(Model model, Sale sale) {
		
		saleService.saveOrUpdate(sale);
		model.addAttribute("saleList", saleService.getAllSale());
		return "sale/sale_list";
	}
	
	@RequestMapping(value="/saleDelete/{id}", method = RequestMethod.GET)
	public String saleDelete(Model model, @PathVariable(required = true, name = "id") Long id) {
		
		saleService.deleteSale(id);;
		model.addAttribute("saleList", saleService.getAllSale());
		return "sale/sale_list";
	}
}
