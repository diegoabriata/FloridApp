package com.floridApp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="barrel")
public class Barrel {
	@Id
	@Column(name = "id")
	private Long id;
	private Double liters;
	@ManyToMany
	@JoinTable(name="sale_barrel",
	joinColumns=@JoinColumn(name="barrel_id"),
	inverseJoinColumns=@JoinColumn(name="sale_id")
			)
	private Set<Sale> sales;
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
	public Set<Sale> getSales() {
		return sales;
	}
	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}
	@Override
	public String toString() {
		return "Barrel [id=" + id + ", liters=" + liters + ", sales=" + sales + "]";
	}
}
