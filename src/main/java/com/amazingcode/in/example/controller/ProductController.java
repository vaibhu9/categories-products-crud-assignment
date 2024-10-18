package com.amazingcode.in.example.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazingcode.in.example.entity.Product;
import com.amazingcode.in.example.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
	}

//	@GetMapping
//	public ResponseEntity<List<Product>> getAllProducts() {
//		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
//	}
	
	@GetMapping
	public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size) {
    	Page<Product> products = productService.getAllProducts(PageRequest.of(page, size));
    	return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {																										// @PathVariable
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product with id "+id+" deleted.");
	}

}
