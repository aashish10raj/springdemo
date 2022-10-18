package com.service.goods.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



import lombok.Data;


@Entity
@Data
@Table(name="customer")
public class Customer {

	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customer_id;
	@Column(name="customer_name")
	private String customer_name;
	@Column(name="expenditure")
	private int expenditure;
	
	@ManyToOne
	@JoinColumn(name="seller_id")
	private Seller seller;
	
public Customer() {
		
	}
	public Customer(int customer_id, String customer_name) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
	}
	
	
	
	
	
	
}
