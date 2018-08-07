package com.floridApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floridApp.model.Barrel;
import com.floridApp.repository.BarrelRepository;

@Service
@Transactional
public class BarrelServiceImpl implements BarrelService {
	
	@Autowired
	BarrelRepository barrelRepository;
	
	@Override
	public List<Barrel> getAllBarrel() {
		return (List<Barrel>) barrelRepository.findAll();
	}

	@Override
	public Barrel getBarrelById(Long id) {
		return barrelRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Barrel barrel) {
		barrelRepository.save(barrel);
	}

	@Override
	public void deleteBarrel(Long id) {
		barrelRepository.deleteById(id);
	}

}
