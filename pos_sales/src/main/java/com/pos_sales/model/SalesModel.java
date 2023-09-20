package com.pos_sales.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_sales")
	public class SalesModel {

		@Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private int invoiceid;
	    
	    private int transactionid;
	    private int total_qty;
	    private double total_bill;
	    private double balance;
	  
	    //getting the product name from the product entity
	    @ManyToOne
	    @JoinColumn(name = "productid")
	    ProductModel product;
		
	    
	    public SalesModel() {}
	    
	    public SalesModel(int invoiceid, int transactionid, int total_qty, double total_bill, double balance, ProductModel product) {
	        this.invoiceid = invoiceid;
	        this.transactionid = transactionid;
	        this.total_qty = total_qty;
	        this.total_bill = total_bill;
	        this.balance = balance;
	        this.product = product;
	    }

		public ProductModel getProduct() {
			return product;
		}

		public void setProduct(ProductModel product) {
			this.product = product;
		}

		public int getInvoiceid() {
			return invoiceid;
		}

//		public void setInvoiceid(int invoiceid) {
//			this.salesid = invoiceid;
//		}

		public int getTransactionid() {
			return transactionid;
		}

		public void setTransactionid(int transactionid) {
			this.transactionid = transactionid;
		}

		public int getTotal_qty() {
			return total_qty;
		}

		public void setTotal_qty(int total_qty) {
			this.total_qty = total_qty;
		}

		public double getTotal_bill() {
			return total_bill;
		}

		public void setTotal_bill(double total_bill) {
			this.total_bill = total_bill;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

	    
}