package com.floridApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.floridApp.model.Barrel;
import com.floridApp.service.BarrelService;

@Controller
@RequestMapping(value="/barrel")
public class BarrelController {
	
	@Autowired
	BarrelService barrelService;
	
	@RequestMapping(value= {"/"}, method=RequestMethod.GET)
	public String barrelList (Model model) {
		model.addAttribute("barrelList", barrelService.getAllBarrel());
		return "barrel/barrel_list";
	}
	
	@RequestMapping(value={"/barrelEdit","/barrelEdit/{id}"}, method = RequestMethod.GET)
	public String barrelEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
		
		if(null != id) {
			model.addAttribute("barrel", barrelService.getBarrelById(id));
		} else {
			model.addAttribute("barrel", new Barrel());
		}
		return "barrel/barrel_addOrUpdate";
	}
	
	/*@RequestMapping(value={"/barrelEdit"}, method = RequestMethod.POST)
	public String barrelEdit(Model model, Barrel barrel) {		
		barrelService.saveOrUpdate(barrel);
		model.addAttribute("barrelList", barrelService.getAllBarrel());
		return "redirect:/barrel/";
	}*/
	
	@RequestMapping(value={"/barrelSave"}, method = RequestMethod.POST)
	//@ResponseBody
	public String barrelEdit(Model model, @RequestParam Long id,  @RequestParam Double litersCapacity) {		
		
		Barrel barrel = new Barrel();
		barrel.setId(id);
		barrel.setLitersCapacity(litersCapacity);
		barrelService.saveOrUpdate(barrel);
		model.addAttribute("barrelList", barrelService.getAllBarrel());
		return "redirect:/barrel/";
	}
	
	
	@RequestMapping(value="/barrelDelete/{id}", method = RequestMethod.GET)
	public String barrelDelete(Model model, @PathVariable(required = true, name = "id")Long id) {
		barrelService.deleteBarrel(id);
		model.addAttribute("barrelList", barrelService.getAllBarrel());
		return"redirect:/barrel/";
	}
	
	/*@RequestMapping("/barrel/{id}")
    public String barrel(@PathVariable Long id, Model model){
        model.addAttribute("barrel", barrelService.getBarrelById(id));
        return "barrel";
    }

    @RequestMapping(value = "/barrels",method = RequestMethod.GET)
    public String barrelsList(Model model){
        model.addAttribute("barrels", barrelService.getAllBarrel());
        return "saleOrder/barrels";
    }

    @RequestMapping(value = "/savebarrel", method = RequestMethod.POST)
    @ResponseBody
    public String saveBarrel(@RequestBody Barrel barrel) {
        
    	barrelService.saveOrUpdate(barrel);
        return barrel.getId().toString();
    }*/

}
