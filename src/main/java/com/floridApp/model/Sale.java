package com.floridApp.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sale")
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "remito")
	private String remito;
	@Column(name = "date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date date;
	@Column(name = "total")
	private Double total;
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	/*@ManyToMany
	@JoinTable(name="sale_barrel",
	joinColumns=@JoinColumn(name="sale_id"),
	inverseJoinColumns=@JoinColumn(name="barrel_id")
			)
	private Set<Barrel> barrels;*/
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sale")
	private Set<SaleOrder> saleOrderList;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRemito() {
		return remito;
	}

	public void setRemito(String remito) {
		this.remito = remito;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<SaleOrder> getSaleOrderList() {
		return saleOrderList;
	}

	public void setSaleOrderList(Set<SaleOrder> saleOrderList) {
		this.saleOrderList = saleOrderList;
	}

	
	
}
