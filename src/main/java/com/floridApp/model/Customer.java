package com.floridApp.model;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name = "first_name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "dni")
	private Integer dni;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "email")
	private String email;
	
	//mappedBy: look at the information from the Sale class @JoinColumn
	@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
	private Set<Sale> sales = new HashSet<Sale>(0);
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Sale> getSales() {
		return sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + ", dni=" + dni
				+ ", company=" + company + ", email=" + email + ", sales=" + sales + "]";
	}
}
