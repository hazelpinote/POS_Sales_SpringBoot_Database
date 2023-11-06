package com.pos_sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.pos_sales.model.AccountsModel;
import com.pos_sales.service.AccountsService;



@RestController
@CrossOrigin("http://localhost:3000")
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
					return
							aserv.deleteAccount(userid);
				}
				
				@PostMapping("/login")
				public ResponseEntity<String> login(@RequestBody AccountsModel loginRequest) {
				    AccountsModel user = aserv.findByUsername(loginRequest.getUsername());
				    if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
				        // Successful login
				        return new ResponseEntity<>("Login successful", HttpStatus.OK);
				    } else {
				        // Failed login
				        return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
				    }
				}
				
				@PostMapping("/logincash")
				public ResponseEntity<String> logincash(@RequestBody AccountsModel loginRequest) {
				    AccountsModel user = aserv.findByUsername(loginRequest.getUsername());
				    
				    if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
				        // Check the account_type to see if the user is a cashier
				        if ("Cashier".equals(user.getAccount_type())) {
				            // Successful login for a cashier user
				            return new ResponseEntity<>("Login successful", HttpStatus.OK);
				        } else {
				            // Reject login for users with other account types
				            return new ResponseEntity<>("Access denied for this account type", HttpStatus.FORBIDDEN);
				        }
				    } else {
				        // Failed login
				        return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
				    }
				}

				@PostMapping("/loginsales")
				public ResponseEntity<String> loginsales(@RequestBody AccountsModel loginRequest) {
				    AccountsModel user = aserv.findByUsername(loginRequest.getUsername());
				    
				    if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
				        // Check the account_type to see if the user is a cashier
				        if ("Sales Manager".equals(user.getAccount_type())) {
				            // Successful login for a cashier user
				            return new ResponseEntity<>("Login successful", HttpStatus.OK);
				        } else {
				            // Reject login for users with other account types
				            return new ResponseEntity<>("Access denied for this account type", HttpStatus.FORBIDDEN);
				        }
				    } else {
				        // Failed login
				        return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
				    }
				}		
				
				
				@PostMapping("/loginad")
				public ResponseEntity<String> loginad(@RequestBody AccountsModel loginRequest) {
				    AccountsModel user = aserv.findByUsername(loginRequest.getUsername());
				    
				    if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
				        // Check the account_type to see if the user is a cashier
				        if ("Administrator".equals(user.getAccount_type())) {
				            // Successful login for a cashier user
				            return new ResponseEntity<>("Login successful", HttpStatus.OK);
				        } else {
				            // Reject login for users with other account types
				            return new ResponseEntity<>("Access denied for this account type", HttpStatus.FORBIDDEN);
				        }
				    } else if(user != null && user.getPassword().equals(null)) {
				    	return new ResponseEntity<>("Please enter your username and password.", HttpStatus.FORBIDDEN);
				    } else {
				    	// Failed login
				        return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
				    }
				        
				    }			
}