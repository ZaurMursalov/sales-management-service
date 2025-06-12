package com.example.mstapaz.service;

import com.example.mstapaz.entity.CategoryEntity;

public interface CategoryService {

    void saveCategory(String name);
    CategoryEntity getCategory(String name);
}
