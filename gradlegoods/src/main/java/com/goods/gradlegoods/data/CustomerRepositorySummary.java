package com.goods.gradlegoods.data;

import org.springframework.data.repository.CrudRepository;

import com.goods.gradlegoods.entities.CustomerSummary;

public interface CustomerRepositorySummary extends CrudRepository<CustomerSummary, Integer>{

}
