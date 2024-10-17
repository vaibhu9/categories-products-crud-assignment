package com.amazingcode.in.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amazingcode.in.example.entity.Category;
import com.amazingcode.in.example.repository.CategoryRepository;
import com.amazingcode.in.example.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategory(Long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		Category existCategory = categoryRepository.findById(id).get();
		if (existCategory == null) {
			return null;
		}
		category.setCategoryId(id);
		Category updatedCategory = categoryRepository.save(category);
		return updatedCategory;
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}
