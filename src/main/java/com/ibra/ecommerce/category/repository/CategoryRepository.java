package com.ibra.ecommerce.category.repository;

import com.ibra.ecommerce.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
