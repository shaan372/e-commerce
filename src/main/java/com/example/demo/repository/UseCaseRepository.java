package com.example.demo.repository;

import com.example.demo.entity.UseCase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UseCaseRepository extends CrudRepository<UseCase, Integer> {

    @Query(value = "select * from use_case where product_id = ?1", nativeQuery = true)
    List<UseCase> findUseCaseByProduct(Integer productId);
}
