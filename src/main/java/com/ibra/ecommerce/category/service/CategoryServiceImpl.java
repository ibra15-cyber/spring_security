package com.ibra.ecommerce.category.service;

import com.ibra.ecommerce.category.model.Category;
import com.ibra.ecommerce.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

//    private List<Category> categories = new ArrayList<>();
//    private Long nextId = 1L;

    CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
//        category.setCategoryId(nextId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long id){
//        for (Category category : categories) {
//            if(category.getCategoryId().equals(id)){
//                categories.remove(category);
//            }
//        }
//
//        Category category = categories.stream()
//                .filter(item -> item.getCategoryId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

//        if (category == null) {
//            return "Category not found";
//        }

//        categories.remove(category);
//        return "Category with categoryId " + category.getCategoryId() + " deleted successfully";


//        categoryRepository.deleteById(id);
        Category deletedCategory = categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        categoryRepository.delete(deletedCategory);
        return "Category deleted";

    }

    @Override
    public Category updateCategory(Long id, Category category) {
//        Optional<Category> itemToUpadte = categories.stream()
//                .filter(item -> item.getCategoryId()
//                                .equals(id)).findFirst();
//        if (itemToUpadte.isPresent()) {
//            Category existingCategory = itemToUpadte.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            return existingCategory;
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
//        }
        Category updateCategory = categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

//        updateCategory.setCategoryId(category.getCategoryId());
        updateCategory.setCategoryName(category.getCategoryName());
        categoryRepository.save(updateCategory);
        return updateCategory;

    }
}
