package com.service.goods.data;

import org.springframework.data.repository.CrudRepository;


import com.service.goods.entities.Seller;

public interface SellerData  extends CrudRepository<Seller, Integer>{

}
