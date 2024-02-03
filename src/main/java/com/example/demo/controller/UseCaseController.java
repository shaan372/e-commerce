package com.example.demo.controller;

import com.example.demo.entity.UseCase;
import com.example.demo.service.UseCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/use-case")
public class UseCaseController {

    @Autowired
    private UseCaseService useCaseService;

    @GetMapping("/{productId}")
    ResponseEntity<List<UseCase>> findUseCaseByProductId(@PathVariable Integer productId){
        List<UseCase> useCases = useCaseService.findUseCaseByProductId(productId);
        return new ResponseEntity<>(useCases, HttpStatus.OK);
    }
}
