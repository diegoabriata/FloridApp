package com.floridApp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="sales_orders")
public class SaleOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "sale_id")
	private Sale sale;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "barrel_id")
	private Barrel barrel;
	
	//Additional fields source: https://www.codejava.net/frameworks/hibernate/hibernate-many-to-many-association-with-extra-columns-in-join-table-example
	@Column(name = "type_beer")
	private String typeBeer;
	
	@Column(name="beer_price")
	private Double beerPrice;
	
	@Column(name="barrel_liters")
	private Double barrelLiters;
	
	@Column(name = "barrel_status")
	private boolean barrelStatus; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Barrel getBarrel() {
		return barrel;
	}

	public void setBarrel(Barrel barrel) {
		this.barrel = barrel;
	}

	public String getTypeBeer() {
		return typeBeer;
	}

	public void setTypeBeer(String typeBeer) {
		this.typeBeer = typeBeer;
	}

	public Double getBeerPrice() {
		return beerPrice;
	}

	public void setBeerPrice(Double beerPrice) {
		this.beerPrice = beerPrice;
	}

	public Double getBarrelLiters() {
		return barrelLiters;
	}

	public void setBarrelLiters(Double barrelLiters) {
		this.barrelLiters = barrelLiters;
	}

	public boolean isBarrelStatus() {
		return barrelStatus;
	}

	public void setBarrelStatus(boolean barrelStatus) {
		this.barrelStatus = barrelStatus;
	}
}
