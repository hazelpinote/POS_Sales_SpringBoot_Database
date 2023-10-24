package com.pos_sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos_sales.model.AccountsModel;
import com.pos_sales.model.TransactionModel;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsModel, Integer>{
		AccountsModel findByUsername(String username); 
		AccountsModel findByUserid(int userid); 
}