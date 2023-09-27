package com.pos_sales.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_transaction")
	public class TransactionModel {

		@Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private int transactionid;
	    
	    private int total_quantity;
	    private double total_price;
	    private double tendered_bill;
	    private double balance;
	    private String customer_name;
	    private String customer_num;
	    private String customer_email;
	    private String date_time;
	    
	    //getting the farm name from the product model
	    @ManyToOne
		@JoinColumn(name="productid")
		ProductModel product;
	    
	    //getting the farm name from the product model
	    @ManyToOne
		@JoinColumn(name="userid")
		AccountsModel account;
		
	    
	    public TransactionModel() {}
	    
	    public TransactionModel(int transactionid, int total_quantity, double total_price, double tendered_bill, double balance, String customer_name, 
	    		String customer_num, String customer_email, String date_time,  ProductModel product, AccountsModel account) {
	        this.transactionid = transactionid;
	        this.total_quantity = total_quantity;
	        this.total_price = total_price;
	        this.tendered_bill = tendered_bill;
	        this.balance = balance;
	        this.customer_name = customer_name;
	        this.customer_num = customer_num;
	        this.customer_email = customer_email;
	        this.date_time = date_time;
	        this.product = product;
	        this.account = account;
	    }

	    
	    //SETTERS AND GETTERS

		public String getDate_time() {
			return date_time;
		}

		public void setDate_time(String date_time) {
			this.date_time = date_time;
		}

		public String getCustomer_name() {
			return customer_name;
		}

		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}

		public String getCustomer_num() {
			return customer_num;
		}

		public void setCustomer_num(String customer_num) {
			this.customer_num = customer_num;
		}

		public String getCustomer_email() {
			return customer_email;
		}

		public void setCustomer_email(String customer_email) {
			this.customer_email = customer_email;
		}

		public int getTransactionid() {
			return transactionid;
		}

//		public void setTransactionid(int transactionid) {
//			this.transactionid = transactionid;
//		}

		public ProductModel getProduct() {
			return product;
		}

		public void setProduct(ProductModel product) {
			this.product = product;
		}

		public AccountsModel getAccount() {
			return account;
		}

		public void setAccount(AccountsModel account) {
			this.account = account;
		}

		public int getTotal_quantity() {
			return total_quantity;
		}

		public void setTotal_quantity(int total_quantity) {
			this.total_quantity = total_quantity;
		}

		public double getTotal_price() {
			return total_price;
		}

		public void setTotal_price(double total_price) {
			this.total_price = total_price;
		}

		public double getTendered_bill() {
			return tendered_bill;
		}

		public void setTendered_bill(double tendered_bill) {
			this.tendered_bill = tendered_bill;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}


	    
}