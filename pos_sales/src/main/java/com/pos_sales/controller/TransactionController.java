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
			
			
	
}
