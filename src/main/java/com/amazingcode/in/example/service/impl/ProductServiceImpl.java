package com.amazingcode.in.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.amazingcode.in.example.entity.Product;
import com.amazingcode.in.example.exception.AlreadyPresentException;
import com.amazingcode.in.example.exception.NotPresentException;
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
		boolean isProductPresent = productRepository.existsByProductName(product.getProductName());
		if(isProductPresent) {
			throw new AlreadyPresentException("Product with name "+product.getProductName()+" is already present.");
		}
		return productRepository.save(product);
	}

//	@Override
//	public List<Product> getAllProducts() {
//		List<Product> existsProducts = productRepository.findAll();
//		if(existsProducts.isEmpty()||existsProducts==null) {
//			throw new NotPresentException("Products not present.");
//		}
//		return existsProducts;
//	}
	
	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		Page<Product> existsProducts = productRepository.findAll(pageable);
		if(existsProducts.isEmpty()||existsProducts==null) {
			throw new NotPresentException("Products not present.");
		}
		return existsProducts;
	}

	@Override
	public Product getProduct(Long id) {
		Optional<Product> existProduct = productRepository.findById(id);
		if(existProduct.isEmpty()) {
			throw new NotPresentException("Product with id "+id+" does not present.");
		}
		return existProduct.get();
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Optional<Product> existProduct = productRepository.findById(id);
		if(existProduct.isEmpty()) {
			throw new NotPresentException("Product with id "+id+" does not present.");
		}
		product.setProductId(id);
		Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}

	@Override
	public void deleteProduct(Long id) {
		Optional<Product> existProduct = productRepository.findById(id);
		if(existProduct.isEmpty()) {
			throw new NotPresentException("Product with id "+id+" does not exist to delete.");
		}
		productRepository.deleteById(id);
	}

}
