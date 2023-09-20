package com.pos_sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionHistory transhis;
	
			//Test
			@GetMapping("/print")
			public String printHelloTransaction() {
				return "Hello, Transaction";
			}
			
			//Create or insert a transaction
			@PostMapping("/postTransaction")
			public ProductModel insertProduct(@RequestBody ProductModel product) {
				return transhis.insertProduct(product);
			}
			
			//Read all records
			@GetMapping("/getAllTransaction")
			public List<ProductModel> getAllProduct(){
				return transhis.getAllProduct();
			}
			
			//Read a record by product name
			@GetMapping("/getByProduct")
			public ProductModel findByProductname(@RequestParam String productname) {
				return transhis.findByProductName(productname);	
			}
			
			//Update a record
			@PutMapping("/putProduct")
			public ProductModel putProduct(@RequestParam int productid, @RequestBody ProductModel newProductDetails) throws Exception{
				return pserv.putProduct(productid, newProductDetails);
			}
			
			//Delete a record
			@DeleteMapping("/deleteProduct/{productid}")
			public String deleteProduct(@PathVariable int productid) {
				return pserv.deleteProduct(productid);
			}
	
}
