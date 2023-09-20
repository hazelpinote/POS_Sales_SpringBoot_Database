package com.pos_sales.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos_sales.model.SalesModel;
import com.pos_sales.repository.SalesRepository;


@Service
public class SalesService {
	@Autowired	
	SalesRepository srepo;
	
	//C - Create or insert a sales record
	public SalesModel insertSales(SalesModel sales) {
		return srepo.save(sales);
	}
	
	//Read a record from the table named tbl_sales
	public List<SalesModel> getAllSales() {
		return srepo.findAll();
	}
	
	//R - Read or search student record by invoice name
			public SalesModel findByTransactionid(int transactionid) {
				if (srepo.findByTransactionid(transactionid) !=null)
					return srepo.findByTransactionid(transactionid);
				else
					return null;
			}
			
			//U - Update a invoice record
			public SalesModel putSales(int invoiceid, SalesModel newSalesDetails) throws Exception{
				SalesModel sales = new SalesModel();
				
				try {
					//steps in updating
					//Step 1 - search the id number of the product
					sales = srepo.findById(invoiceid).get();  //findById() is a pre-defined method
					
					//Step 2 - update the record
					sales.setTotal_qty(newSalesDetails.getTotal_qty());
					sales.setTotal_bill(newSalesDetails.getTotal_bill());
					sales.setBalance(newSalesDetails.getBalance());
					
					//Step 3 - save the information and return the value
					return srepo.save(sales);
					
				} catch (NoSuchElementException nex) {
					throw new Exception("Sales " + invoiceid + " does not exist!");
				}
			}
			
			//D - Delete sales record
			public String deleteSales(int invoiceid) {
				String msg;
				if (srepo.findById(invoiceid) != null) {					//Step 1 - find the record
					srepo.deleteById(invoiceid);                                //Step 2 - delete the record
					
					msg = "Invoice #" + invoiceid  + " successfully deleted!";
				} else
					msg = "Invoce #" + invoiceid + " is NOT found!";
				
				return msg;
			}
}
