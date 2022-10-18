package com.goods.gradlegoods.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goods.gradlegoods.data.SellerData;

import com.goods.gradlegoods.entities.Seller;
import java.util.regex.*;  
import com.goods.gradlegoods.exception.IOException;
import com.goods.gradlegoods.exception.SellerNotFoundException;
import com.goods.gradlegoods.service.SellerService;




@RestController
@CrossOrigin
public class SellerController {
	
	@Autowired
	private SellerService sellerservice;
	@Autowired
	private SellerData sellerdata;
	
	
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	// displaying list of all sellers
			@GetMapping("/sellers")
			public ResponseEntity<List<Seller>> getAllSellers(){
								
				List<Seller> sellerdetails= sellerservice.getAllSellers();
				if(sellerdetails.isEmpty()) {
					throw new SellerNotFoundException(0);
				}
				return ResponseEntity.of(Optional.of(sellerdetails));
				
			}
			
			//displaying sellers by id
			@GetMapping("/sellers/{id}")
			public ResponseEntity<Optional<Seller>> getSeller(@PathVariable int id){
				Optional<Seller> seller = sellerservice.getSeller(id);
				
				if(seller.isEmpty()) {
					throw new SellerNotFoundException(id);
				}
				logger.trace("seller's data fetched successfully");
				return ResponseEntity.of(Optional.of(seller));
				
			}
			
	//inserting sellers details
			@PostMapping("/sellers")
			public ResponseEntity<Seller> addSeller(@RequestBody Seller s){
				Pattern p = Pattern.compile("^[ A-Za-z]+$");
				Matcher m = p.matcher(s.getSeller_name());
				boolean b = m.matches();
				if( b && s.getEarning()<65534) {
					sellerservice.addSeller(s);
					return ResponseEntity.status(HttpStatus.CREATED).build();
				}
				else {
					throw new IOException();
				}
			}
			
			//deleting sellers by id
			@DeleteMapping("sellers/{id}")
			public ResponseEntity<Void> deleteSellerByID(@PathVariable int id){
				if(sellerdata.existsById(id)) {
					
					sellerservice.deleteSellerByID(id);
					return ResponseEntity.ok().build();
				}

			else {
					throw new SellerNotFoundException(id);
				}
				
			}
			
}
			
			
			
			



