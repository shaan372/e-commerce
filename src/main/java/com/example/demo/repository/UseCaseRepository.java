package com.example.demo.repository;

import com.example.demo.entity.UseCase;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseCaseRepository extends CrudRepository<UseCase, Integer> {

    @Query(value = "select * from use_case where product_id = ?1", nativeQuery = true)
    List<UseCase> findUseCaseByProduct(Integer productId);
}
