package com.amazingcode.in.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amazingcode.in.example.entity.Product;
import com.amazingcode.in.example.repository.ProductRepository;
import com.amazingcode.in.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product existProduct = productRepository.findById(id).get();
		if (existProduct == null) {
			return null;
		}
		product.setProductId(id);
		Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
