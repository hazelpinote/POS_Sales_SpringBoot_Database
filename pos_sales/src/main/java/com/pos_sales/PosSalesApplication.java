package com.pos_sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PosSalesApplication {

	@Autowired
	private EmailService senderService;
	
	public static void main(String[] args) {
		SpringApplication.run(PosSalesApplication.class, args);
	}

	
}
