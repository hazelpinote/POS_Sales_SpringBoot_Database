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
import com.pos_sales.service.ProductService;


@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:3000")
public class ProductController {

		@Autowired
		ProductService pserv;

		//Test
				@GetMapping("/print")
				public String printHelloProduct() {
					return "Hello, Product!";
				}
		
				//Create or insert a product record
				@PostMapping("/postProduct")
				public ProductModel insertProduct(@RequestBody ProductModel product) {
					return pserv.insertProduct(product);
				}
				
				//Read all records
				@GetMapping("/getAllProduct")
				public List<ProductModel> getAllProduct(){
					return pserv.getAllProduct();
				}
				
				//Read a record by product name
				@GetMapping("/getByProduct")
				public ProductModel findByProductname(@RequestParam String productname) {
					return pserv.findByProductName(productname);	
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