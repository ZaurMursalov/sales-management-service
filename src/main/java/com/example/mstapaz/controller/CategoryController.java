package com.example.mstapaz.controller;

import com.example.mstapaz.entity.CategoryEntity;
import com.example.mstapaz.service.CategoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCategory(@RequestBody String name){
        categoryService.saveCategory(name);
    }

    @GetMapping("/{name}")
    public CategoryEntity getCategory(@PathVariable String name){
        return categoryService.getCategory(name);
    }
}
