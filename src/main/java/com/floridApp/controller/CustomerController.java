package com.floridApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.floridApp.model.Customer;
import com.floridApp.service.CustomerService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController{

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value= {"/","/list"}, method=RequestMethod.GET)
	public String customersList( Model model) {
		model.addAttribute("customerList", customerService.getAllCustomer());		
		return "customer/customer_list";
	}

	@RequestMapping(value={"/customerEdit","/customerEdit/{id}"}, method = RequestMethod.GET)
	public String customerEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
		
		if (null != id) {
			model.addAttribute("customer", customerService.getCustomerById(id));
		} else {
			model.addAttribute("customer", new Customer());
		}
		return "customer/customer_addOrUpdate";
	}
	@RequestMapping(value={"/customerEdit"}, method = RequestMethod.POST)
	public String customerEdit(Model model, Customer customer) {
		
		customerService.saveOrUpdate(customer);
		model.addAttribute("customerList", customerService.getAllCustomer());
		return "customer/customer_list";
	}
	
	@RequestMapping(value="/customerDelete/{id}", method = RequestMethod.GET)
	public String customerDelete(Model model, @PathVariable(required = true, name = "id") Long id) {
		
		customerService.deleteCustomer(id);
		model.addAttribute("customerList", customerService.getAllCustomer());
		return "customer/customer_list";
	}
	
	/*@RequestMapping(value="/addCustomer/", method=RequestMethod.GET)
	public ModelAndView addCustomer() {
		ModelAndView model = new ModelAndView();
		
		Customer customer =  new Customer();
		model.addObject("customerForm",customer);
		model.setViewName("home/customer_form");
		
		return model;
	}
	
	@RequestMapping(value="/updateCustomer/{id}", method = RequestMethod.GET)
	public ModelAndView editCustomer(@PathVariable Long id){
		ModelAndView model = new ModelAndView(); 
		
		Customer customer = customerService.getCustomerById(id);
		
		model.addObject("customer",customer);
		model.setViewName("home/customer_form");
		
		return model;
		
	}
	
	@RequestMapping(value="/saveCustomer", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("customerForm") Customer customer) {
		
		customerService.saveOrUpdate(customer);
		
		return new ModelAndView("redirect:/customer/list");
	}
	
	@RequestMapping(value="/deleteCustomer/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
		
		return new ModelAndView("redirect:/customer/list");
	}*/
	
	
}
