package com.floridApp.model;

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
	private Double liters;
	/*@ManyToMany
	@JoinTable(name="sale_barrel",
	joinColumns=@JoinColumn(name="barrel_id"),
	inverseJoinColumns=@JoinColumn(name="sale_id")
			)
	private Set<Sale> sales;*/
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="barrel")
	private Set<SaleOrder> saleOrderList;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getLiters() {
		return liters;
	}
	public void setLiters(Double liters) {
		this.liters = liters;
	}
	public Set<SaleOrder> getSaleOrderList() {
		return saleOrderList;
	}
	public void setSaleOrderList(Set<SaleOrder> saleOrderList) {
		this.saleOrderList = saleOrderList;
	}
	@Override
	public String toString() {
		return "Barrel [id=" + id + ", liters=" + liters + ", saleOrderList=" + saleOrderList + "]";
	}
}
