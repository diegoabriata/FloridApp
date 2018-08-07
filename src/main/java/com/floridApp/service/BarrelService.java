package com.floridApp.service;

import java.util.List;

import com.floridApp.model.Barrel;



public interface BarrelService {
	
	public List<Barrel> getAllBarrel();
	public Barrel getBarrelById(Long id);
	public void saveOrUpdate(Barrel barrel);
	public void deleteBarrel(Long id);
}
