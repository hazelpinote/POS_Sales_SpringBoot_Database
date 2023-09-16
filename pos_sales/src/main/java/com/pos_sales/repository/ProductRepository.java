package com.pos_sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos_sales.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer>{
		ProductModel findByProductname(String productname); 
}