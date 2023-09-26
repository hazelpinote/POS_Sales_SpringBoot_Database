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
	    
	    //getting the farm name from the product model
	    @ManyToOne
		@JoinColumn(name="productid")
		ProductModel product;
	    
	    //getting the farm name from the product model
	    @ManyToOne
		@JoinColumn(name="userid")
		AccountsModel account;
		
	    
	    public TransactionModel() {}
	    
	    public TransactionModel(int transactionid, int total_quantity, double total_price, double tendered_bill, double balance, ProductModel product, AccountsModel account) {
	        this.transactionid = transactionid;
	        this.total_quantity = total_quantity;
	        this.total_price = total_price;
	        this.tendered_bill = tendered_bill;
	        this.balance = balance;
	        this.product = product;
	        this.account = account;
	    }

	    
	    //SETTERS AND GETTERS

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