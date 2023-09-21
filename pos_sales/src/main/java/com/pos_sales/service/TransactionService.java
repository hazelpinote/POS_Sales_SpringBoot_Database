package com.pos_sales.service;

import java.util.List;


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
	
//	//R - Read or search student record by product name
//			public TransactionModel findByTransactionid(int transactionid) {
//				if (trepo.findByTransactionid(transactionid) !=null)
//					return trepo.findByTransactionid(transactionid);
//				else
//					return null;
//			}
			
//			//U - Update a product record
//			public ProductModel putProduct(int productid, ProductModel newProductDetails) throws Exception{
//				ProductModel product = new ProductModel();
//				
//				try {
//					//steps in updating
//					//Step 1 - search the id number of the product
//					product = prepo.findById(productid).get();  //findById() is a pre-defined method
//					
//					//Step 2 - update the record
//					product.setProductname(newProductDetails.getProductname());
//					product.setQuantity(newProductDetails.getQuantity());
//					product.setPrice(newProductDetails.getPrice());
//					
//					//Step 3 - save the information and return the value
//					return prepo.save(product);
//					
//				} catch (NoSuchElementException nex) {
//					throw new Exception("Product " + productid + " does not exist!");
//				}
//			}
//			
//			//D - Delete product record
//			public String deleteProduct(int productid) {
//				String msg;
//				if (prepo.findById(productid) != null) {					//Step 1 - find the record
//					prepo.deleteById(productid);                                //Step 2 - delete the record
//					
//					msg = "Product " + productid  + " successfully deleted!";
//				} else
//					msg = "Product " + productid + " is NOT found!";
//				
//				return msg;
//			}
}
