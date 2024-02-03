package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    List<Category> findAllCategories(){
        List<Category> categories = StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .toList();
        return categories;
    }

    Category findCategoryById(Integer id){
        Category category = categoryRepository.findById(id).orElse(null);
        return category;
    }

    Category saveCategory(Category category){
        Category category1 = categoryRepository.save(category);
        return category1;
    }
}
