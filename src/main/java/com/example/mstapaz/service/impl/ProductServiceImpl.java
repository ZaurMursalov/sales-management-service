package com.example.mstapaz.service.impl;

import com.example.mstapaz.entity.CategoryEntity;
import com.example.mstapaz.entity.ProductAttribute;
import com.example.mstapaz.entity.ProductEntity;
import com.example.mstapaz.entity.UserEntity;
import com.example.mstapaz.mapper.ProductMapper;
import com.example.mstapaz.model.ProductRequest;
import com.example.mstapaz.model.response.ProductResponse;
import com.example.mstapaz.repository.CategoryRepository;
import com.example.mstapaz.repository.ProductRepository;
import com.example.mstapaz.repository.UserRepository;
import com.example.mstapaz.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public abstract class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse createProduct(ProductRequest request, String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        CategoryEntity category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        ProductEntity product = new ProductEntity();
        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCreatedAt(LocalDateTime.now());
        product.setOwner(user);
        product.setCategory(category);

        List<ProductAttribute> attributes = request.getAttributes().stream().map(attr -> {
            ProductAttribute pa = new ProductAttribute();
            pa.setKey(attr.getKey());
            pa.setValue(attr.getValue());
            pa.setProduct(product);
            return pa;
        }).collect(Collectors.toList());

        product.setAttributes(attributes);

        ProductEntity saved = productRepository.save(product);
        return ProductMapper.mapToResponse(saved);


    }

    // digər metodlar da əlavə ediləcək (getAll, getById, getMyProducts, deleteProduct)
}
