package com.pos_sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos_sales.model.TransactionModel;


@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Integer>{
		TransactionModel findByTransactionid(int transactionid); 
}