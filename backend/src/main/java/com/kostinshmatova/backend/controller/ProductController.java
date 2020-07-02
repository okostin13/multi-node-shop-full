package com.kostinshmatova.backend.controller;

import com.kostinshmatova.backend.dto.CategoryDto;
import com.kostinshmatova.backend.dto.ProductDto;
import com.kostinshmatova.backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/category")
    public List<CategoryDto> getAllCategories(){
        return productService.getAllCategories();
    }

    @GetMapping("/product")
    public List<ProductDto> getProductsByCategoryId(@RequestParam Long categoryId){
        return productService.getByCategoryId(categoryId);
    }

    @GetMapping("/product/{id}")
    public ProductDto getProductsById(@PathVariable Long id){
        return productService.getById(id);
    }
}
