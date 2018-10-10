package com.floridApp.model;


import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="barrel")
public class Barrel {
	@Id
	@Column(name = "id")
	private Long id;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="barrel")
	private List<SaleOrder> salesOrders;
	
	
	@Column(name = "liters_capacity")
	private Double litersCapacity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<SaleOrder> getSalesOrders() {
		return salesOrders;
	}
	public void setSalesOrders(List<SaleOrder> salesOrders) {
		this.salesOrders = salesOrders;
	}
	public Double getLitersCapacity() {
		return litersCapacity;
	}
	public void setLitersCapacity(Double litersCapacity) {
		this.litersCapacity = litersCapacity;
	}
	
}
