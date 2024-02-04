package com.example.demo.controller;

import com.example.demo.dto.request.CategoryRequest;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId") Integer categoryId){
    Category category = categoryService.findCategoryById(categoryId);
    return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Category> saveCategory(@RequestBody CategoryRequest categoryRequest){
        Category category = categoryService.saveCategory(categoryRequest);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
