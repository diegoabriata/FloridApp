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
@Table(name="sale_order")
public class SaleOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name = "type_beer")
	private String typeBeer;
	
	@Column(name="beer_price")
	private Double beerPrice;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "sale_id")
	private Sale sale;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "barrel_id")
	private Barrel barrel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "SaleOrder [id=" + id + ", typeBeer=" + typeBeer + ", beerPrice=" + beerPrice + ", sale=" + sale
				+ ", barrel=" + barrel + "]";
	}
}
