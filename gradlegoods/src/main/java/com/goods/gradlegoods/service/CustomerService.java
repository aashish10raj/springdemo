package com.goods.gradlegoods.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.goods.gradlegoods.data.CustomerData;
import com.goods.gradlegoods.data.CustomerRepositorySummary;

import com.goods.gradlegoods.data.SellerData;
import com.goods.gradlegoods.entities.Customer;

import com.goods.gradlegoods.entities.CustomerSummary;
import com.goods.gradlegoods.entities.CustomerView;
import com.goods.gradlegoods.entities.CustomerViewClassImpl;
import com.goods.gradlegoods.entities.Seller;
import com.goods.gradlegoods.exception.SellerNotFoundException;



@Service

public class CustomerService {

	@Autowired
	private CustomerData customerdata;
	
	@Autowired
	private SellerData sellerdata;
	
	@Autowired
	private CustomerRepositorySummary customerrepo;
	
	
	
		
	
	// fetching all customers
	
			public List<Customer> getAllCustomers(){
				List<Customer> cust = (List<Customer>)customerdata.findAll(); 
				return cust;
			}
			
//			public int getAllCustomersNumbers(){
//				int cust = ((List<Customer>) customerdata.findAll()).size(); 
//				return cust;
//			}
			
			
			// fetching customer by id
			public Optional<Customer> getCustomer(int id){
				return customerdata.findById(id);
			}
			
	//inserting customer data and updating the seller's income col with the expense of customer
			public Customer addCustomer(Customer c) {
				customerdata.save(c);
				Optional<Seller> sellerDetails = sellerdata.findById(c.getSeller().getId()); 
				
				if(sellerDetails.isEmpty()) {
					throw new SellerNotFoundException(0);
				}
				else
				{
					int earning=  sellerDetails.get().getEarning();
					int income = c.getExpenditure();
					earning+=earning+income;
					sellerDetails.get().setEarning(earning);
					sellerdata.save(sellerDetails.get());				
					
				}							
				return c;							
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

			//fetch all customers along with the seller 
			
			public List<CustomerSummary> getAllCustomersUsingSeller(){
				List<CustomerSummary> cust = (List<CustomerSummary>) customerrepo.findAll(); 
				return cust;
			
			}
			
			
			public CustomerService(CustomerData customerdata) {
				super();
				this.customerdata = customerdata;
			}
			
			//fetch only the required data
			
			public List<CustomerView> getSpecificDetails(String name){
				List<CustomerView> list = new ArrayList<>();
				customerdata.findByName(name).forEach(list::add);
				return list;
				
			}

			public Customer updateCustomer(Customer c, int id) {
				
				if(id == c.getId()) {
					customerdata.save(c);
				}
				return c;
			}
			
//			public List<CustomerViewClassImpl> getSpecificDetailsClass(String name){
//				List<CustomerViewClassImpl> list = new ArrayList<>();
//				customerdata.findByName(name).forEach(list::add);
//				return list;
//				
//			}
			
			
}
