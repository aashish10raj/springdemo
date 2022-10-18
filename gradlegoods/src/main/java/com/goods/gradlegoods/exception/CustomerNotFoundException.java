package com.goods.gradlegoods.exception;




public class CustomerNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	

	public CustomerNotFoundException(int id) {
		// TODO Auto-generated constructor stub
		super("Customer id not found : " + id);
	}
	
	
		
}
