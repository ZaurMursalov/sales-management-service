package com.example.mstapaz.service;

import com.example.mstapaz.model.ProductRequest;
import com.example.mstapaz.model.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request, String username);
    List<ProductResponse> getAll();
    ProductResponse getById(Long id);
    List<ProductResponse> getMyProducts(String username);
    void deleteProduct(Long id, String username);
}