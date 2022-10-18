package com.goods.gradlegoods.entities;

import org.springframework.beans.factory.annotation.Value;

public interface CustomerView {

	//using closed projections
//int getId();
//String getName();
//
//SellerView getSeller();
	
	//using the open projections
	
	@Value("#{target.name +target.id }")
	String getFullName();
	
	
}
