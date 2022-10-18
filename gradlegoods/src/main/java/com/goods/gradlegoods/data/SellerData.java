package com.goods.gradlegoods.data;




import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


import com.goods.gradlegoods.entities.Seller;



@Repository

public interface SellerData  extends CrudRepository<Seller, Integer>{
	
	

}