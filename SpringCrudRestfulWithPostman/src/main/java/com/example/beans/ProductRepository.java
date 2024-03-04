package com.example.beans;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

	private List<Product> productRecords;
	private static ProductRepository prdtrepo = null;
	
	private ProductRepository() {
		productRecords = new ArrayList<Product>();
	}
	
	public static ProductRepository getInstance() {
		if(prdtrepo == null) {
			prdtrepo = new ProductRepository();
			return prdtrepo;
		} else {
			return prdtrepo;
		}
	}
	
	public void add(Product prd) {
		productRecords.add(prd);
	}
	
	public String updateProduct(Product prd) {
		for (int i = 0; i < productRecords.size(); i++) {
			Product prdn = productRecords.get(i);
			if (prdn.getPrice().equals(prd.getPrice())) {
				productRecords.set(i, prd);
				return "updated Successful";
			}
		}
		return "Update Failed";
	}
	
	public String deleteProduct(Integer price) {
		for (int i = 0; i < productRecords.size(); i++) {
			Product prdn = productRecords.get(i);
			if (prdn.getPrice().equals(price)) {
				productRecords.remove(i);
				return "Delete Successfull";
			}
		}
		return "Delete Failed";
	}
	
	public List<Product> getProductRecords() {
		return productRecords;
	}
	
}
