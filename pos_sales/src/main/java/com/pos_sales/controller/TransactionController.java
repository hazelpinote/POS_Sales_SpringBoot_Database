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
@CrossOrigin("https://dilven-pos.vercel.app")
@RequestMapping("/transaction")
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
				
				//Read a record by transaction id
				@GetMapping("/getByTransaction")
				public TransactionModel findByTransactionid(@RequestParam int transactionid) {
					return tserv.findByTransactionid(transactionid);	
				}
//				
				//Update a record
				@PutMapping("/putTransaction")
				public TransactionModel putTransaction(@RequestParam int transactionid, @RequestBody TransactionModel newTransactionDetails) throws Exception{
					return tserv.putTransaction(transactionid, newTransactionDetails);
				}
				
				//isRefunded
				@PutMapping("/isRefunded")
				public TransactionModel isRefunded(@RequestParam int transactionid, @RequestBody TransactionModel newTransactionDetails) throws Exception{
					return tserv.isRefund(transactionid, newTransactionDetails);
				}
				
				//isReturned
				@PutMapping("/isReturned")
				public TransactionModel isReturned(@RequestParam int transactionid, @RequestBody TransactionModel newTransactionDetails) throws Exception{
					return tserv.isReturned(transactionid, newTransactionDetails);
				}
				
				//Delete a record
				@DeleteMapping("/deleteTransaction/{transactionid}")
				public String deleteTransaction(@PathVariable int transactionid) {
					return tserv.deleteTransaction(transactionid);
				}
				
			    @GetMapping("/{transactionId}/products")
			    public List<ProductModel> getProductsForTransaction(@PathVariable int transactionId) {
			        List<ProductModel> products = tserv.getProducts(transactionId);
			        
			        if (products != null) {
			            return products;
			        } else {
			            // Handle the case where the transaction is not found
			            // You can return an error response or appropriate HTTP status code (e.g., 404 Not Found)
			            return null;
			        }
			    }				
}