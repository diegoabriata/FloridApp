package com.floridApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.floridApp.model.Barrel;
import com.floridApp.service.BarrelService;

@Controller
@RequestMapping(value="/barrel")
public class BarrelController {
	
	@Autowired
	BarrelService barrelService;
	
	@RequestMapping(value= {"/","/list"}, method=RequestMethod.GET)
	public String barrelList (Model model) {
		model.addAttribute("barrelList", barrelService.getAllBarrel());
		return "home/barrel_list";
	}
	
	@RequestMapping(value={"/barrelEdit","/barrelEdit/{id}"}, method = RequestMethod.GET)
	public String barrelEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
		
		if(null != id) {
			model.addAttribute("barrel", barrelService.getBarrelById(id));
		} else {
			model.addAttribute("barrel", new Barrel());
		}
		return "home/barrel_addOrUpdate";
	}
	
	@RequestMapping(value={"/barrelEdit"}, method = RequestMethod.POST)
	public String barrelEdit(Model model, Barrel barrel) {		
		barrelService.saveOrUpdate(barrel);
		model.addAttribute("barrelList", barrelService.getAllBarrel());
		return "redirect:/barrel/";
	}
	
	@RequestMapping(value="/barrelDelete/{id}", method = RequestMethod.POST)
	public String barrelDelete(Model model, @PathVariable(required = true, name = "id")Long id) {
		barrelService.deleteBarrel(id);
		model.addAttribute("barrelList", barrelService.getAllBarrel());
		return"redirect:/barrel/";
	}
}
