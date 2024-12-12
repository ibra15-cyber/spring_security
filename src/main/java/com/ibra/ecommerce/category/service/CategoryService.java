package com.ibra.ecommerce.category.service;

import com.ibra.ecommerce.category.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long id);

    Category updateCategory(Long id, Category category);
}
