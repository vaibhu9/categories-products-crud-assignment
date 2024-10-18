package com.amazingcode.in.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.amazingcode.in.example.entity.Product;

public interface ProductService {

	Product createProduct(Product product);
	
//	List<Product> getAllProducts();
	
	Page<Product> getAllProducts(Pageable pageable);

	Product getProduct(Long id);

	Product updateProduct(Long id, Product product);

	void deleteProduct(Long id);
	
}
