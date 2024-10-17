package com.amazingcode.in.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amazingcode.in.example.entity.Category;
import com.amazingcode.in.example.exception.AlreadyPresentException;
import com.amazingcode.in.example.exception.NotPresentException;
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
		boolean isCategoryPresent = categoryRepository.existsByCategoryName(category.getCategoryName());
		if(isCategoryPresent) {
			throw new AlreadyPresentException("Category with name "+category.getCategoryName()+" is already present.");
		}
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> existsCategories = categoryRepository.findAll();
		if(existsCategories.isEmpty()||existsCategories==null) {
			throw new NotPresentException("Categories not present.");
		}
		return existsCategories;
	}

	@Override
	public Category getCategory(Long id) {
		Optional<Category> existCategory = categoryRepository.findById(id);
		if(existCategory.isEmpty()) {
			throw new NotPresentException("Category with id "+id+" does not exist.");
		}
		return existCategory.get();
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		Optional<Category> existCategory = categoryRepository.findById(id);
		if (existCategory.isEmpty()) {
			throw new NotPresentException("Category with id "+id+" does not exist.");
		}
		category.setCategoryId(id);
		Category updatedCategory = categoryRepository.save(category);
		return updatedCategory;
	}

	@Override
	public void deleteCategory(Long id) {
		Optional<Category> existCategory = categoryRepository.findById(id);
		if (existCategory.isEmpty()) {
			throw new NotPresentException("Category with id "+id+" does not exist to delete.");
		}
		categoryRepository.deleteById(id);
	}

}
