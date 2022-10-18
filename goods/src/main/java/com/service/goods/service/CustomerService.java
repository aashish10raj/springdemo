package com.service.goods.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.service.goods.data.CustomerData;

import com.service.goods.entities.Customer;


@Service

public class CustomerService {

	@Autowired
	private CustomerData customerdata;
	
	
	// fetching all customers
	
			public List<Customer> getAllCustomers(){
				List<Customer> cust = (List<Customer>)customerdata.findAll(); 
				return cust;
			}
	//inserting customer data
			public void addCustomer(Customer c) {
				customerdata.save(c);
				
				
			}
			
			//deleting customer by id
			public void deleteCustomerByID(int id){
				customerdata.deleteById(id);
			}
			
			//fetch customers by particular seller id
			public List<Customer> getAllCustomersBySellerId(int sellerId){
				List<Customer> customers= new ArrayList<>();
				customerdata.findBySellerId(sellerId).forEach(customers::add);
				return customers;
			}
}
