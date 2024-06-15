package com.example.demo.service;

import com.example.demo.dto.request.CategoryRequest;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import java.util.List;
import java.util.stream.StreamSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryService {

    @Autowired private CategoryRepository categoryRepository;

    public List<Category> findAllCategories() {
        List<Category> categories =
                StreamSupport.stream(categoryRepository.findAll().spliterator(), false).toList();
        log.info("Successfully fetched the Category {}", categories);
        return categories;
    }

    public Category findCategoryById(Integer id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return category;
    }

    public Category saveCategory(CategoryRequest category) {
        Category category2 = new Category();
        category2.setName(category.getName());
        Category category1 = categoryRepository.save(category2);
        return category1;
    }
}
