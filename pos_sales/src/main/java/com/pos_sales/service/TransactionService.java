package com.pos_sales.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos_sales.model.TransactionModel;
import com.pos_sales.repository.TransactionRepository;


@Service
public class TransactionService {
	@Autowired
	TransactionRepository trepo;
	
	//C - Create or insert a transaction record
	public TransactionModel insertTransaction(TransactionModel transaction) {
		return trepo.save(transaction);
	}
	
	//Read a record from the table named tbl_transaction
	public List<TransactionModel> getAllTransaction() {
		return trepo.findAll();
	}
	
	//R - Read or search student record by product name
			public TransactionModel findByTransactionid(int transactionid) {
				if (trepo.findByTransactionid(transactionid) !=null)
					return trepo.findByTransactionid(transactionid);
				else
					return null;
			}
			
			//U - Update a product record
			public TransactionModel putTransaction(int transactionid, TransactionModel newTransactionDetails) throws Exception{
				TransactionModel transaction = new TransactionModel();
				
				try {
					//steps in updating
					//Step 1 - search the id number of the product
					transaction = trepo.findById(transactionid).get();  //findById() is a pre-defined method
					
					//Step 2 - update the record
					transaction.setTotal_quantity(newTransactionDetails.getTotal_quantity());
					transaction.setTotal_price(newTransactionDetails.getTotal_price());
					transaction.setTendered_bill(newTransactionDetails.getTendered_bill());
					transaction.setBalance(newTransactionDetails.getBalance());
					transaction.setCustomer_name(newTransactionDetails.getCustomer_name());
					transaction.setCustomer_num(newTransactionDetails.getCustomer_num());
					transaction.setCustomer_email(newTransactionDetails.getCustomer_email());
					transaction.setProduct(newTransactionDetails.getProduct());
					transaction.setAccount(newTransactionDetails.getAccount());
					
					//Step 3 - save the information and return the value
					return trepo.save(transaction);
					
				} catch (NoSuchElementException nex) {
					throw new Exception("Transaction " + transactionid + " does not exist!");
				}
			}
			
			//D - Delete transaction record
			public String deleteTransaction(int transactionid) {
				String msg;
				if (trepo.findById(transactionid) != null) {					//Step 1 - find the record
					trepo.deleteById(transactionid);                                //Step 2 - delete the record
					
					msg = "Transaction " + transactionid  + " successfully deleted!";
				} else
					msg = "Transaction " + transactionid + " is NOT found!";
				
				return msg;
			}
}
