package com.example.demo.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {
    String name;
    Double price;
    Integer categoryId;
    List<Integer> existingUseCases;
    List<UseCaseRequest> addedUseCases;
}
