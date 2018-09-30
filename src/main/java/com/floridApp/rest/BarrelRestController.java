package com.floridApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floridApp.model.Barrel;
import com.floridApp.service.BarrelService;

@RestController
@RequestMapping("/barrelRest")
public class BarrelRestController {
	
	@Autowired
	BarrelService barrelService;
	
	@GetMapping(value= {"/","/barrels"})
	public List<Barrel> barrelList () {
		
		return barrelService.getAllBarrel();
	} 
	///{id}
	
	@GetMapping(value= {"/barrels/{id}"})
	public Barrel barrelEditForm(@PathVariable Long id) {
		 Barrel barrel = barrelService.getBarrelById(id);
		 if(barrel == null) {
			 throw new BarrelNotFoundException("El barril nro:"+ id +" no se encuentra en la db");
		 }
		return barrel;
	}
	//mapping for POST/customers - add new barrel
	@PostMapping("/barrels")
	public Barrel addBarrel(@RequestBody Barrel theBarrel) {
		/*also just in case the pass an id in JSON... set id to 0
		 * this is force a save of new item... instead of update
		 * */
		theBarrel.setId(null);
		barrelService.saveOrUpdate(theBarrel);
		
		return theBarrel;
	}
	
}
