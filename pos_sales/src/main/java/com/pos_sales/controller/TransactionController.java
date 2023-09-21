package com.pos_sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pos_sales.model.ProductModel;
import com.pos_sales.model.TransactionModel;
import com.pos_sales.service.TransactionService;


@RestController
@RequestMapping("/transaction")
@CrossOrigin("http://localhost:3000")
public class TransactionController {

		@Autowired
		TransactionService tserv;

		//Test
				@GetMapping("/print1")
				public String printTest() {
					return "Hello, Test!";
				}
		
				//Create or insert a product record
				@PostMapping("/postTransaction")
				public TransactionModel insertTransaction(@RequestBody TransactionModel transaction) {
					return tserv.insertTransaction(transaction);
				}
				
				//Read all records
				@GetMapping("/getAllTransaction")
				public List<TransactionModel> getAllTransaction(){
					return tserv.getAllTransaction();
				}
				
//				//Read a record by product name
//				@GetMapping("/getByTransaction")
//				public TransactionModel findByTransactionid(@RequestParam int transactionid) {
//					return tserv.findByTransactionid(transactionid);	
//				}
////				
//				//Update a record
//				@PutMapping("/putProduct")
//				public ProductModel putProduct(@RequestParam int productid, @RequestBody ProductModel newProductDetails) throws Exception{
//					return pserv.putProduct(productid, newProductDetails);
//				}
//				
//				//Delete a record
//				@DeleteMapping("/deleteProduct/{productid}")
//				public String deleteProduct(@PathVariable int productid) {
//					return pserv.deleteProduct(productid);
//				}
}