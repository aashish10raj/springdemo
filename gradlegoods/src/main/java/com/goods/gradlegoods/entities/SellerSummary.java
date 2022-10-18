package com.goods.gradlegoods.entities;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



import lombok.Data;

@Entity
@Data
@Table(name="seller")
public class SellerSummary {

	@Id
	@Column(name="seller_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="seller_name")
	private String seller_name;
	
	@Column(name="earning")
	private int earning;
	
	public SellerSummary(int id, String seller_name, int earning) {
		super();
		this.id = id;
		this.seller_name = seller_name;
		this.earning = earning;
		
	}

	public SellerSummary() {
		super();
		// TODO Auto-generated constructor stub
	}
}
