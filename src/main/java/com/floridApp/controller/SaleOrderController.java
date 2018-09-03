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
	SaleOrderService saleOrderService;
	@Autowired
	SaleService saleService;
	@Autowired
	BarrelService barrelService;
	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping(value={"/saleOrderEdit","/saleOrderEdit/{id}"}, method = RequestMethod.GET)
	public String saleEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
		
		if (null != id) {
			model.addAttribute("sale", saleService.getSaleById(id));
			model.addAttribute("saleCustomers", customerService.getAllCustomer());
			model.addAttribute("barrelList", barrelService.getAllBarrel());
		} else {

			model.addAttribute("saleCustomers", customerService.getAllCustomer());
			model.addAttribute("barrelList", barrelService.getAllBarrel());
			model.addAttribute("sale", new Sale());
			model.addAttribute("saleOrder", new SaleOrder());
		}
		
		return "sale/sale_addOrUpdate";
	}
	@RequestMapping(value={"/saleOrderEdit"}, method = RequestMethod.POST)
	public String saleEdit(Model model, @ModelAttribute("sale") Sale sale, @ModelAttribute("saleOrder") SaleOrder saleOrder, @ModelAttribute("dateString") String date, BindingResult result) throws ParseException {
		
		if(result.hasErrors()) {
			System.out.println("error post sales, Description: " + sale.getDescription() +
					" id: "+ sale.getId() + " customer: "+ sale.getCustomer() + " date: "+ sale.getDate());
		}else {
			
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	        Date d1 = format1.parse( date );
	        sale.setDate(d1);
	        
			saleService.saveOrUpdate(sale);
			saleOrderService.saveOrUpdate(saleOrder);
			model.addAttribute("saleList", saleService.getAllSale());
		}
		
		return "sale/sale_list";
	}
	
	
	
}
