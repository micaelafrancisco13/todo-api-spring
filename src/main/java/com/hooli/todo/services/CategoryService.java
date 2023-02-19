package com.hooli.todo.services;

import com.hooli.todo.exceptions.ResourceNotFoundException;
import com.hooli.todo.models.Category;
import com.hooli.todo.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategory(@PathVariable Long categoryId) {
        var category = categoryRepository.findById(categoryId).orElseThrow
                (() -> new ResourceNotFoundException("The category with the ID of " + categoryId + " was not found."));
        return category;
    }
}
