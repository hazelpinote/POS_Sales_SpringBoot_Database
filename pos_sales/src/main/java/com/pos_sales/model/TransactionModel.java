package com.pos_sales.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_transactions")
	public class TransactionModel {

		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private int invoiceid;
		
		private int transactionid;
		private String item_name;
		private int total_quantity;
		private double price;
		private double total_price;
		private String customer_name;
		private String customer_num;
		private String customer_email;
		private String transaction_date;
		
		public TransactionModel() {}
		
		public TransactionModel(int invoiceid, int transactionid, String item_name, int total_quantity, double price, double total_price, String customer_name, String customer_email, String tran_date) {
			this.invoiceid = invoiceid;
			this.transactionid = transactionid;
			this.total_quantity = total_quantity;
			this.price = price;
			this.total_price = total_price;
			this.customer_name = customer_name;
			
		}
	}
