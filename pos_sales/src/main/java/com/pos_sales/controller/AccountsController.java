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

import com.pos_sales.model.AccountsModel;
import com.pos_sales.service.AccountsService;



@RestController
@RequestMapping("/user")
public class AccountsController {

		@Autowired
		AccountsService aserv;

		//Test
				@GetMapping("/print")
				public String printHelloUser() {
					return "Hello, User!";
				}
		
				//Create or insert a user record
				@PostMapping("/postUser")
				public AccountsModel insertAccount(@RequestBody AccountsModel account) {
					return aserv.insertAccount(account);
				}
				
				//Read all records
				@GetMapping("/getAllUser")
				public List<AccountsModel> getAllUser(){
					return aserv.getAllAccounts();
				}
				
				//Read a record by user name
				@GetMapping("/getByUser")
				public AccountsModel findByUsername(@RequestParam String username) {
					return aserv.findByUsername(username);	
				}
				
				//Update a record
				@PutMapping("/putUser")
				public AccountsModel putAccounts(@RequestParam int userid, @RequestBody AccountsModel newAccountsDetails) throws Exception{
					return aserv.putAccounts(userid, newAccountsDetails);
				}
				
				//Delete a record
				@DeleteMapping("/deleteAccount/{userid}")
				public String deleteAccount(@PathVariable int userid) {
					return aserv.deleteAccount(userid);
				}
}