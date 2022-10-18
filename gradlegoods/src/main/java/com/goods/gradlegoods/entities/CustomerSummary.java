package com.goods.gradlegoods.entities;




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
public class CustomerSummary {
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="customer_name")
	private String name;
	@Column(name="expenditure")
	private int expenditure;
	@Column(name="email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name="seller_id")
	private SellerSummary seller;
	
	public CustomerSummary() {
			
		}

	public CustomerSummary(int id, String name, int expenditure, SellerSummary seller) {
		super();
		this.id = id;
		this.name = name;
		this.expenditure = expenditure;
		this.seller = seller;
	}


		
		
		
		
	

}
