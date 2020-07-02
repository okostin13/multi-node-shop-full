package com.kostinshmatova.productservice.controller;

import com.kostinshmatova.productservice.dao.CategoryDao;
import com.kostinshmatova.productservice.dao.ProductDao;
import com.kostinshmatova.productservice.dto.ProductDto;
import com.kostinshmatova.productservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.kostinshmatova.productservice.mapper.ProductMapper.toDto;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    @Autowired
    public ProductController(ProductDao productDao, CategoryDao categoryDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    @RequestMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id){
        return toDto(productDao.getOne(id));
    }

    @RequestMapping
    public List<ProductDto> getByCategory(@RequestParam Long categoryId){
        return productDao.findByCategory_Id(categoryId).stream().map(
                product -> toDto(product)
        ).collect(Collectors.toList());
    }
}
