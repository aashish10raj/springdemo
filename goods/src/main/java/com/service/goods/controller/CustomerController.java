package com.service.goods.controller;

import java.util.List;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.service.goods.entities.Customer;

import com.service.goods.service.CustomerService;
import com.service.goods.service.SellerService;



@RestController

public class CustomerController {

	@Autowired 
	private CustomerService customerservice;
	@Autowired SellerService sellerservice;
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	
	// displaying list of all customers
			@GetMapping("/customers")
			public List<Customer> getAllCustomer(){
				logger.trace("accessed list of customers successfully");
				return customerservice.getAllCustomers();
			}
			
	//inserting customers details
			@PostMapping("/customers")
			public void addCustomer(@RequestBody Customer c){
				customerservice.addCustomer(c);
				logger.trace("inserted customer's data successfully");
			}
			
			//deleting customer by id
			@DeleteMapping("customers/{id}")
			public void deleteEmployeeByID(@RequestBody Customer c, @PathVariable int id){
				customerservice.deleteCustomerByID(id);
			}
			
			//displaying customers based on seller id
			@GetMapping("/customersbyseller/{id}")
			public List<Customer> getAllCustomersBySellerId(@PathVariable int id){
				logger.trace("accessed list of customers by seller id successfully");
				return customerservice.getAllCustomersBySellerId(id);
			}
			
	
}
