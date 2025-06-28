package com.example.mstapaz.repository;

import com.example.mstapaz.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByOwnerUsername(String username);

}
