package com.example.mstapaz.controller;

import com.example.mstapaz.model.ProductRequest;
import com.example.mstapaz.model.response.ProductResponse;
import com.example.mstapaz.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product Controller", description = "Əməliyyatlar: məhsul əlavə etmək, silmək və gətirmək")
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "Yeni məhsul yarat", description = "Daxil olmuş istifadəçi üçün yeni məhsul əlavə edir")
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @RequestBody ProductRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ProductResponse response = productService.createProduct(request, username);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Bütün məhsulları al", description = "Sistemdəki bütün məhsulları geri qaytarır")
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @Operation(summary = "Daxil olmuş istifadəçinin məhsulları", description = "Hazırda sistemə daxil olan istifadəçinin məhsullarını geri qaytarır")
    @GetMapping("/me")
    public ResponseEntity<List<ProductResponse>> getMe() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(productService.getMyProducts(username));
    }

    @Operation(summary = "İstənilən istifadəçinin məhsulları", description = "İstifadəçi adını verərək həmin istifadəçinin məhsullarını al")
    @GetMapping("/username/{username}")
    public ResponseEntity<List<ProductResponse>> getMyProducts(
            @Parameter(description = "İstifadəçi adı") @PathVariable String username) {
        return ResponseEntity.ok(productService.getMyProducts(username));
    }

    @Operation(summary = "Məhsulu sil", description = "ID-yə görə məhsulu silir")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(
            @Parameter(description = "Silinəcək məhsulun ID-si") @PathVariable Long id) {
        productService.deleteProduct(id);
    }
}