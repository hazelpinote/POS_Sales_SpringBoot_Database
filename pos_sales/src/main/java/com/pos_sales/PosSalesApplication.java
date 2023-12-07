package com.pos_sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class PosSalesApplication {

	@Autowired
	private EmailService senderService;

	// Load environment variables from .env file
	
	public static void main(String[] args) {
		SpringApplication.run(PosSalesApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail() {
//		senderService.sendResetEmail("", "");
//	}
	
}
