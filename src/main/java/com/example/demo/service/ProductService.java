package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

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
}
