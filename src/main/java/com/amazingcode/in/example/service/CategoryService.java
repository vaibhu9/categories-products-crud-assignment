package com.amazingcode.in.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.amazingcode.in.example.entity.Category;

public interface CategoryService {

	Category createCategory(Category category);
	
//	List<Category> getAllCategory();
	
	Page<Category> getAllCategory(Pageable pageable);

	Category getCategory(Long id);

	Category updateCategory(Long id, Category category);

	void deleteCategory(Long id);
	
}
