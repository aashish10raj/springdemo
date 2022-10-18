package com.goods.gradlegoods.entities;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import lombok.Data;


@Entity
@Data
@Table(name="customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	@Column(name="customer_name")
	private String name;
	
	@Column(name="expenditure")
	
	private int expenditure;
	
	
	@NotNull
	@Email
	@Column(name="email")
	private String email;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="seller_id")
	@JsonBackReference
	private Seller seller;
	
public Customer() {
		
	}

public Customer(int id, String name, int expenditure, Seller seller) {
	super();
	this.id = id;
	this.name = name;
	this.expenditure = expenditure;
	this.seller = seller;
}


	
	
	
	
	
	
	
}

