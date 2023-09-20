package com.pos_sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pos_sales.model.SalesModel;
import com.pos_sales.service.SalesService;



@RestController
@RequestMapping("/sales")
public class SalesController {

		@Autowired
		SalesService saserv;

		//Test
				@GetMapping("/print")
				public String printHelloSales() {
					return "Hello, Sales!";
				}
		
				//Create or insert a sales record
				@PostMapping("/postSales")
				public SalesModel insertSales(@RequestBody SalesModel sales) {
					return saserv.insertSales(sales);
				}
				
				//Read all sales records
				@GetMapping("/getAllSales")
				public List<SalesModel> getAllSales(){
					return saserv.getAllSales();
				}
				
				//Update a record
				@PutMapping("/putSales")
				public SalesModel putProduct(@RequestParam int invoiceid, @RequestBody SalesModel newSalesDetails) throws Exception{
					return saserv.putSales(invoiceid, newSalesDetails);
				}
				
				//Delete a record
				@DeleteMapping("/deleteSales/{invoiceid}")
				public String deleteSales(@PathVariable int invoiceid) {
					return saserv.deleteSales(invoiceid);
				}
}