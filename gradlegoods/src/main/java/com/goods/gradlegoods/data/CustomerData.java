package com.goods.gradlegoods.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.goods.gradlegoods.entities.Customer;

import com.goods.gradlegoods.entities.CustomerView;
import com.goods.gradlegoods.entities.CustomerViewClassImpl;








public interface CustomerData extends CrudRepository<Customer, Integer> {

	public List<Customer> findBySellerId(int sellerId);
	

	public List<CustomerView> findByName(String name);
	
	//public List<CustomerViewClassImpl> findByName(String name);

	
	
			
}