package com.amazingcode.in.example.service;

import java.util.List;

import com.amazingcode.in.example.entity.Category;

public interface CategoryService {

	Category createCategory(Category category);
	
	List<Category> getAllCategory();

	Category getCategory(Long id);

	Category updateCategory(Long id, Category category);

	void deleteCategory(Long id);
	
}
