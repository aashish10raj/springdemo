package com.service.goods.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;



import lombok.Data;

@Entity
@Data
@Table(name="seller")
public class Seller {
 
	@Id
	@Column(name="seller_id")
	private int id;
	
	@Column(name="seller_name")
	private String seller_name;
	
	@Column(name="earning")
	private int earning;

	
	
	public Seller()
	{
		
	}
	public Seller(int id, String seller_name) {
		super();
		this.id = id;
		this.seller_name = seller_name;
	}
	
	
	
	
}
