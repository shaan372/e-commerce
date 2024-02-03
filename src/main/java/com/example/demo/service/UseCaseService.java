package com.example.demo.service;

import com.example.demo.entity.UseCase;
import com.example.demo.repository.UseCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseCaseService {

    @Autowired
    private UseCaseRepository useCaseRepository;

    public List<UseCase> findUseCaseByProductId(Integer productId){
        List<UseCase> useCases = useCaseRepository.findUseCaseByProduct(productId);
        return useCases;
    }
}
