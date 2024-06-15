package com.example.demo.dto.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
