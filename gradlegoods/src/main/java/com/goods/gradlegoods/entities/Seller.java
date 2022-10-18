package com.goods.gradlegoods.entities;





import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
@Table(name="seller")
public class Seller implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="seller_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="seller_name")
	private String seller_name;
	
	@Column(name="earning")
	private int earning;
	
	@OneToMany(mappedBy="seller", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Customer> customer;

	public Seller(int id, String seller_name, int earning) {
		super();
		this.id = id;
		this.seller_name = seller_name;
		this.earning = earning;
		
	}

	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
