package com.pos_sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos_sales.model.SalesModel;


@Repository
public interface SalesRepository extends JpaRepository<SalesModel, Integer>{
	SalesModel findByTransactionid(int transactionid); 
}