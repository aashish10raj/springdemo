package com.service.goods.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.service.goods.entities.Customer;





public interface CustomerData extends CrudRepository<Customer, Integer> {

	public List<Customer> findBySellerId(int sellerId);
	
	
			
}
