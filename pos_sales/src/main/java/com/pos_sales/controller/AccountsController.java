package com.pos_sales.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pos_sales.model.AccountsModel;
import com.pos_sales.service.AccountsService;



@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
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
				
				
				//Read a record by username
				@GetMapping("/getByUser")
				public AccountsModel findByUsername(@RequestParam String username) {
					return aserv.findByUsername(username);	
				}

				@GetMapping("/getUserById")
				public AccountsModel findByUserid(@RequestParam int userid) { return aserv.findByUserid(userid);}


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
				
				
				@PostMapping({"/loginad"})
			    public ResponseEntity<String> loginad(@RequestBody AccountsModel loginRequest) {
			        AccountsModel user = this.aserv.findByUsername(loginRequest.getUsername());
			        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
			            return "Administrator".equals(user.getAccount_type()) ? new ResponseEntity(user, HttpStatus.OK) : new ResponseEntity("Access denied for this account type", HttpStatus.FORBIDDEN);
			        } else {
			            return user != null && user.getPassword().equals((Object)null) ? new ResponseEntity("Please enter your username and password.", HttpStatus.FORBIDDEN) : new ResponseEntity("Invalid credentials", HttpStatus.UNAUTHORIZED);
			        }
			   }
				
				@PostMapping("forgotpassword") 
				public ResponseEntity<String> resetPassword(@RequestBody AccountsModel resetRequest) {
				    String email = resetRequest.getEmail();
				    
				    // Check if the email exists in the database
				    AccountsModel account = aserv.findByEmail(email);
				    
				    if (account != null) {
				        String resetToken = generateResetToken();

				        // Set the expiration time for the reset token (e.g., 24 hours from now)
				        LocalDateTime expirationTime = LocalDateTime.now().plusHours(24);
				        account.setResetToken(resetToken);
				        account.setResetTokenExpiration(expirationTime);
				      
				        aserv.insertAccount(account);

				        // Send an email with the reset link
				        sendResetEmail(account.getEmail(), resetToken);

				        return new ResponseEntity<>("Password reset email sent successfully", HttpStatus.OK);
				    } else {
				        return new ResponseEntity<>("Email not found", HttpStatus.NOT_FOUND);
				    }
				}

				@Autowired
				private JavaMailSender javaMailSender;

				public void sendResetEmail(String toEmail, String resetToken) {
				    MimeMessage message = javaMailSender.createMimeMessage();
				    MimeMessageHelper helper = new MimeMessageHelper(message);

				    try {
				        helper.setTo(toEmail);
				        helper.setSubject("Password Reset");
				        helper.setText("<p>Click <a href='http://localhost:3000/changepassword?token=" + resetToken + "'>this link</a> to reset your password</p>  <p> This link will expire in 24 hours.", true);

				        javaMailSender.send(message);
				        
				        System.out.println("Mail sent successfully...");
				    } catch (MessagingException e) {
				        e.printStackTrace();
				        // Handle the exception
				    }
				}


			    // Add a method to generate a reset token
			    private String generateResetToken() {
			    	return UUID.randomUUID().toString();
			    }
			    
			    @CrossOrigin(origins = "http://localhost:3000")
			  //Update a record
				@PutMapping("/changepassword")
				public AccountsModel ChangePassword(@RequestParam String resetToken, @RequestBody AccountsModel newAccountsDetails) throws Exception{
					return aserv.updatePassword(resetToken, newAccountsDetails);
				}

	}
