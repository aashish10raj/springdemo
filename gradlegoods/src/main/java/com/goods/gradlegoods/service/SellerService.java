package com.goods.gradlegoods.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goods.gradlegoods.data.SellerData;

import com.goods.gradlegoods.entities.Seller;



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
				public Seller addSeller(Seller s) {
					sellerdata.save(s);
					return s;
				}
				
				//searching seller by id
				
				public Optional<Seller> getSeller(int id){
					return sellerdata.findById(id);
				}
				
				//deleting sellers by id
				public void deleteSellerByID(int id){
					sellerdata.deleteById(id);
				}
				
				
				
}
