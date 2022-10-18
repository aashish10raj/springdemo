package com.employee.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_ID;
	private String role_Name;
	
	
	public Role(int role_ID, String role_Name) {
		super();
		this.role_ID = role_ID;
		this.role_Name = role_Name;
	}


	public int getRole_ID() {
		return role_ID;
	}


	public void setRole_ID(int role_ID) {
		this.role_ID = role_ID;
	}


	public String getRole_Name() {
		return role_Name;
	}


	public void setRole_Name(String role_Name) {
		this.role_Name = role_Name;
	}
	
	

}
