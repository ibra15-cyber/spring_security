package com.ibra.ecommerce.category.controller;

import com.ibra.ecommerce.category.model.Category;
import com.ibra.ecommerce.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/public/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> response = categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category created");
    }
    @DeleteMapping("/api/public/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        try {
            String response = categoryService.deleteCategory(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    @PutMapping("/api/public/categories/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        try {
            Category response = categoryService.updateCategory(id, category);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("category with categoryId: " + response.getCategoryId() + "updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/api/user")
    public ResponseEntity<String> hellouser() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello user");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/admin")
    public ResponseEntity<String> helloadmin() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello admin");
    }
}
