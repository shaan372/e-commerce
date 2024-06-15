package com.example.demo.service;

import com.example.demo.dto.request.UseCaseRequest;
import com.example.demo.entity.UseCase;
import com.example.demo.repository.UseCaseRepository;
import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseCaseService {

    @Autowired private UseCaseRepository useCaseRepository;

    public List<UseCase> findUseCaseByProductId(Integer productId) {
        List<UseCase> useCases = useCaseRepository.findUseCaseByProduct(productId);
        return useCases;
    }

    public List<UseCase> findAllUseCasesByIds(List<Integer> ids) {
        List<UseCase> useCases =
                StreamSupport.stream(useCaseRepository.findAllById(ids).spliterator(), false)
                        .toList();
        return useCases;
    }

    public List<UseCase> saveAllUseCases(List<UseCaseRequest> useCaseRequests) {
        List<UseCase> useCases =
                useCaseRequests.stream()
                        .map(
                                (useCaseRequest -> {
                                    UseCase useCase = new UseCase();
                                    useCase.setDescription(useCaseRequest.getDescription());
                                    return useCase;
                                }))
                        .toList();
        List<UseCase> useCaseList =
                StreamSupport.stream(useCaseRepository.saveAll(useCases).spliterator(), false)
                        .toList();
        return useCaseList;
    }
}
