package com.example.demo.service;

import com.example.demo.dto.request.ProductRequest;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.UseCase;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UseCaseService useCaseService;

    @Autowired
    private CategoryService categoryService;

    public List<Product> findAllProducts(){
        List<Product> products = StreamSupport
                .stream(productRepository.findAll().spliterator(), false)
                .toList();
        return products;
    }

    public Product findProductById(Integer id){
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    public List<Product> findProductByCategoryId(Integer categoryId){
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return products;
    }

    @Transactional
    public Product saveProduct(ProductRequest productRequest){
        List<UseCase> existingUseCases = useCaseService.findAllUseCasesByIds(productRequest.getExistingUseCases());
        List<UseCase> addedUseCases = useCaseService.saveAllUseCases(productRequest.getAddedUseCases());
        List<UseCase> useCases = new ArrayList<>();
        useCases.addAll(existingUseCases);
        useCases.addAll(addedUseCases);
        Category category = categoryService.findCategoryById(productRequest.getCategoryId());
        Product product = new Product();
        product.setCategory(category);
        product.setUseCases(useCases);
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

}
