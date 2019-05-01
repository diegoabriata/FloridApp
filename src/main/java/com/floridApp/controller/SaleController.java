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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.floridApp.model.Sale;
import com.floridApp.service.CustomerService;
import com.floridApp.service.SaleOrderService;
import com.floridApp.service.SaleService;

@Controller
@RequestMapping(value="/sale")
public class SaleController {
	
	@Autowired
	SaleService saleService;

	@Autowired
	CustomerService customerService;
	
	@Autowired
	SaleOrderService saleOrderService;
	
	@RequestMapping(value= {"/","/list"}, method=RequestMethod.GET)
	public String saleList( Model model) {
		model.addAttribute("saleList", saleService.getAllSale());
		model.addAttribute("orders", saleOrderService.getAllSaleOrder());	
		return "sale/sale_list";
	}

	@RequestMapping(value={"/saleEdit","/saleEdit/{id}"}, method = RequestMethod.GET)
	public String saleEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
		
		if (null != id) {
			
			model.addAttribute("sale", saleService.getSaleById(id));
			model.addAttribute("saleCustomers", customerService.getAllCustomer());
		} else {

			model.addAttribute("saleCustomers", customerService.getAllCustomer());
			model.addAttribute("sale", new Sale());
		}
		
		return "sale/sale_addOrUpdate";
	}
	//https://stackoverflow.com/questions/7429649/how-to-pass-model-attributes-from-one-spring-mvc-controller-to-another-controlle
	@RequestMapping(value={"/saleEdit"}, method = RequestMethod.POST)
	public String saleEdit(
			Model model, 
			@ModelAttribute("sale") final Sale sale, 
			@ModelAttribute("dateString") String date, 
			BindingResult mapping1BindingResult,
			final RedirectAttributes redirectAttributes) throws ParseException {
		
		if(mapping1BindingResult.hasErrors()) {
			System.out.println("error post sales, Description: " + sale.getDescription() +
					" id: "+ sale.getId() + " customer: "+ sale.getCustomer() + " date: "+ sale.getDate());
		}else {
			
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	        Date d1 = format1.parse(date);
	        sale.setDate(d1); 
	        sale.setTotal(0.0);
	        
			saleService.saveOrUpdate(sale);
			
			redirectAttributes.addFlashAttribute("sale", sale);
			
		}
		
		return "redirect:/order/";
	}
	@RequestMapping(value="/saleDelete/{id}", method = RequestMethod.GET)
	public String saleDelete(Model model, @PathVariable(required = true, name = "id") Long id) {
		
		saleService.deleteSale(id);
		model.addAttribute("saleList", saleService.getAllSale());
		return "sale/sale_list";
	}
}
