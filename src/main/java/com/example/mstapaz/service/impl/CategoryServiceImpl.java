package com.example.mstapaz.service.impl;

import com.example.mstapaz.entity.CategoryEntity;
import com.example.mstapaz.repository.CategoryRepository;
import com.example.mstapaz.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void saveCategory(String name) {
        CategoryEntity categoryEntity = CategoryEntity.builder()
                .name(name)
                .build();
        categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity getCategory(String name) {
        var category=fetchExists(name);
        return CategoryEntity.builder()
                .name(category.getName())
                .build();
    }

    private CategoryEntity fetchExists(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(()->new RuntimeException("Category not found"));
    }
}
