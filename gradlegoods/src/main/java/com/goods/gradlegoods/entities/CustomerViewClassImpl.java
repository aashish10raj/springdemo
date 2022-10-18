package com.goods.gradlegoods.entities;

public class CustomerViewClassImpl {

	private int id;
    private String name;
 

    public CustomerViewClassImpl(int id, String name) {
        this.id=id;
        this.name=name;
    }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
    
	
}
