package com.example.mstapaz.controller;

import com.example.mstapaz.entity.CategoryEntity;
import com.example.mstapaz.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Tag(name = "Category Controller", description = "Məhsul kateqoriyalarının yaradılması və axtarışı")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Yeni kateqoriya əlavə et", description = "Verilən ad əsasında yeni kateqoriya yaradır")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCategory(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Kateqoriya adı (sadəcə string)")
            @RequestBody String name) {
        categoryService.saveCategory(name);
    }

    @Operation(summary = "Kateqoriya əldə et", description = "Ad əsasında kateqoriya məlumatını geri qaytarır")
    @GetMapping("/{name}")
    public CategoryEntity getCategory(
            @Parameter(description = "Kateqoriyanın adı")
            @PathVariable String name) {
        return categoryService.getCategory(name);
    }
}