package com.goods.gradlegoods.controller;


	import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
	import org.slf4j.Logger;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.goods.gradlegoods.data.CustomerData;
import com.goods.gradlegoods.data.SellerData;
import com.goods.gradlegoods.entities.Customer;

import com.goods.gradlegoods.entities.CustomerSummary;
import com.goods.gradlegoods.entities.CustomerView;

import com.goods.gradlegoods.exception.CustomerNotFoundException;
import com.goods.gradlegoods.exception.IOException;
import com.goods.gradlegoods.exception.SellerNotFoundException;
import com.goods.gradlegoods.service.CustomerService;
import com.goods.gradlegoods.service.SellerService;


	



	@RestController
	@CrossOrigin
	public class CustomerController {

		@Autowired 
		private CustomerService customerservice;
		@Autowired SellerService sellerservice;
		@Autowired
		private SellerData sellerdata;
		@Autowired
		private CustomerData customerdata;
		Logger logger = LoggerFactory.getLogger(CustomerController.class);
		
		
		// displaying list of all customers without the seller details
				@GetMapping("/customers")				
				public ResponseEntity<List> getAllCustomer(@RequestParam(required = true) boolean fetchSeller){
					
					if(!fetchSeller) {
					logger.trace("accessed list of customers successfully");
					List<Customer> list = customerservice.getAllCustomers();
					if(list.size()==0) {
						throw new CustomerNotFoundException(0);
					}
					return ResponseEntity.of(Optional.of(list)) ;
				}
					else {
						List<CustomerSummary> list = customerservice.getAllCustomersUsingSeller();
						if(list.isEmpty()) {
							throw new IOException();
				}
						else
							return ResponseEntity.of(Optional.of(list));
					}
						}
					
				
				 //displaying customers by id
				@GetMapping("/customers/{id}")
				public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable int id){
					Optional<Customer> customer = customerservice.getCustomer(id);
					
					if(!customerdata.existsById(id)) {
						throw new CustomerNotFoundException(id);
					}
					logger.trace("customer's data fetched successfully");
					return ResponseEntity.of(Optional.of(customer));
					
				}
				
				//displaying customers along with the seller details
//				@GetMapping("/customerswithseller/{flag}")
//				public ResponseEntity<List<CustomerSummary>> getAllCustomersUsingSeller(@PathVariable boolean flag){
//					//logger.trace("accessed list of customers by seller id successfully");
//					List<CustomerSummary> list = customerservice.getAllCustomersUsingSeller(flag);
//					if(list.isEmpty()) {
//						throw new IOException();
//					}
//					else
//						return ResponseEntity.of(Optional.of(list));
//				}
				
				
				
		//inserting customers details
				@PostMapping("/customers")
				public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer c, BindingResult bindingResult){
					Pattern p = Pattern.compile("^[ A-Za-z]+$");
					Matcher m = p.matcher(c.getName());
					boolean b = m.matches();
					if(bindingResult.hasErrors())
					{
						throw new IOException();
					}
					if(b && c.getExpenditure()<65534) {
						if(!sellerdata.existsById(c.getSeller().getId()))
						{
							throw new SellerNotFoundException(0);
						}
												
						customerservice.addCustomer(c);
						logger.trace("inserted customer's data successfully");
						return ResponseEntity.status(HttpStatus.CREATED).build();
					
				}else {
					throw new IOException();
				}
				}
				
				//deleting customer by id
				@DeleteMapping("customers/{id}")
				public ResponseEntity<Void> deleteCustomerByID(@PathVariable int id){
					if(customerdata.existsById(id)) {
						customerservice.deleteCustomerByID(id);
						return ResponseEntity.ok().build();
					}
					else {
						throw new CustomerNotFoundException(id);
					}
					
				}
				
				//displaying customers based on seller id
				@GetMapping("/customersbyseller/{id}")
				public ResponseEntity<List<Customer>> getAllCustomersBySellerId(@PathVariable int id){
					logger.trace("accessed list of customers by seller id successfully");
					List<Customer> list= customerservice.getAllCustomersBySellerId(id);
					if(list.isEmpty()) {
						throw new CustomerNotFoundException(id);
					}
					return ResponseEntity.status(HttpStatus.OK).body(list);
				}
				
				//fetching only specific details
				@GetMapping("/customeridonly/{name}")
				public ResponseEntity<List<CustomerView>> getSpecificDetails(@PathVariable String name){
					
				List<CustomerView> list = customerservice.getSpecificDetails(name);
				if(list.isEmpty()) {
					throw new CustomerNotFoundException(0);
				}
				return  ResponseEntity.status(HttpStatus.OK).body(list);
										
				}
				
//				@GetMapping("/customeridonlyclass/{name}")
//				public ResponseEntity<List<CustomerViewClassImpl>> getSpecificDetailsClass(@PathVariable String name){
//					
//				List<CustomerViewClassImpl> list = customerservice.getSpecificDetailsClass(name);
//				if(list.isEmpty()) {
//					throw new CustomerNotFoundException(0);
//				}
//				return  ResponseEntity.status(HttpStatus.OK).body(list);
//										
//				}
				
		//put method to modify the data
				@PutMapping("/customers/{id}")
				public void updateCustomer(@RequestBody Customer c, @PathVariable int id){
					customerservice.updateCustomer(c, id);
				}
	}


