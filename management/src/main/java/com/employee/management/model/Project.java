package com.employee.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	
	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int project_ID;
	private String project_Name;
	
	
	public Project(int project_ID, String project_Name) {
		super();
		this.project_ID = project_ID;
		this.project_Name = project_Name;
	}


	public int getProject_ID() {
		return project_ID;
	}


	public void setProject_ID(int project_ID) {
		this.project_ID = project_ID;
	}


	public String getProject_Name() {
		return project_Name;
	}


	public void setProject_Name(String project_Name) {
		this.project_Name = project_Name;
	}
	
	
	
}
