package com.goods.gradlegoods.exception;

public class SellerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1955417242839057847L;
	
	
	public SellerNotFoundException(int id) {
		// TODO Auto-generated constructor stub
		super("Seller id not found : " + id);
	}
}
