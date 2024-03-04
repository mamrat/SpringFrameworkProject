package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Product;
import com.example.beans.ProductRepository;
import com.example.beans.ProductRepositoryRelay;

@RestController
@RequestMapping("/product")
public class ProductController {

	@GetMapping(value = "/getallproducts")
	public List<Product> getAllProducts() {
		return ProductRepository.getInstance().getProductRecords();
	}
	
	@PostMapping(value = "/addproduct")
	public ProductRepositoryRelay registerProduct(@RequestBody Product product) {
		ProductRepositoryRelay productRelay = new ProductRepositoryRelay();
		ProductRepository.getInstance().add(product);
		productRelay.setName(product.getName());
		productRelay.setPrice(product.getPrice());
		
		return productRelay;
	}
	
	@DeleteMapping(value = "/deleteproduct/{price}")
	public String deleteProductRecord(@PathVariable("price") Integer price) {
		return ProductRepository.getInstance().deleteProduct(price);
	}
	
	@PutMapping(value = "/updateproduct")
	public String updateProductRecord(@RequestBody Product prd) {
		return ProductRepository.getInstance().updateProduct(prd);
	}
	
}
