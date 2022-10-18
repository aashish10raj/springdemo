package com.service.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.service.goods.entities.Seller;
import com.service.goods.service.SellerService;

@RestController

public class SellerController {
	
	@Autowired
	private SellerService sellerservice;
	
	// displaying list of all sellers
			@GetMapping("/sellers")
			public List<Seller> getAllSellers(){
				return sellerservice.getAllSellers();
			}
	//uploading sellers details
			@PostMapping("/sellers")
			public void addSeller(@RequestBody Seller s){
				sellerservice.addSeller(s);
			}
			
			


}
