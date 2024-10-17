package com.amazingcode.in.example.service;

import java.util.List;

import com.amazingcode.in.example.entity.Product;

public interface ProductService {

	Product createProduct(Product product);
	
	List<Product> getAllProducts();

	Product getProduct(Long id);

	Product updateProduct(Long id, Product product);

	void deleteProduct(Long id);
	
}
