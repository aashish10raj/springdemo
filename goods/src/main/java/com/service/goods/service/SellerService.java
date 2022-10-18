package com.service.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.goods.data.SellerData;

import com.service.goods.entities.Seller;

@Service

public class SellerService {

	@Autowired
	private SellerData sellerdata;
	
	// fetching all sellers
				public List<Seller> getAllSellers(){
					List<Seller> sel = (List<Seller>)sellerdata.findAll(); 
					return sel;
				}
				//inserting seller data
				public void addSeller(Seller s) {
					sellerdata.save(s);
				}
				
				
}
