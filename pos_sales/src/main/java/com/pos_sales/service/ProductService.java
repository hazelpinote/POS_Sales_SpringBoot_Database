package com.pos_sales.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos_sales.model.ProductModel;
import com.pos_sales.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository prepo;
	
	//C - Create or insert a product record
	public ProductModel insertProduct(ProductModel product) {
		return prepo.save(product);
	}
	
	//Read a record from the table named tbl_supplier
	public List<ProductModel> getAllProduct() {
		return prepo.findAll();
	}
	
	//R - Read or search student record by product name
			public ProductModel findByProductName(String productname) {
				if (prepo.findByProductname(productname) !=null)
					return prepo.findByProductname(productname);
				else
					return null;
			}
			
			//U - Update a product record
			public ProductModel putProduct(int productid, ProductModel newProductDetails) throws Exception{
				ProductModel product = new ProductModel();
				
				try {
					//steps in updating
					//Step 1 - search the id number of the product
					product = prepo.findById(productid).get();  //findById() is a pre-defined method
					
					//Step 2 - update the record
					product.setProductname(newProductDetails.getProductname());
					product.setQuantity(newProductDetails.getQuantity());
					product.setPrice(newProductDetails.getPrice());
					
					//Step 3 - save the information and return the value
					return prepo.save(product);
					
				} catch (NoSuchElementException nex) {
					throw new Exception("Product " + productid + " does not exist!");
				}
			}
			
			public void decreaseProductQuantity(int productid) {
				ProductModel product = prepo.findById(productid).get();

		        // Decrease the product quantity by 1 (or your desired logic)
		        int updatedQuantity = product.getQuantity()- 1;
		        product.setQuantity(updatedQuantity);

		        prepo.save(product);
		    }
			
			//D - Delete product record
			public String deleteProduct(int productid) {
				String msg;
				if (prepo.findById(productid) != null) {					//Step 1 - find the record
					prepo.deleteById(productid);                                //Step 2 - delete the record
					
					msg = "Product " + productid  + " successfully deleted!";
				} else
					msg = "Product " + productid + " is NOT found!";
				
				return msg;
			}
}
