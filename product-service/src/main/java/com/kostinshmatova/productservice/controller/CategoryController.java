package com.kostinshmatova.productservice.controller;

import com.kostinshmatova.productservice.dao.CategoryDao;
import com.kostinshmatova.productservice.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.kostinshmatova.productservice.mapper.CategoryMapper.toDto;


@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping
    public List<CategoryDto> getAll(){
        return categoryDao.findAll().stream().map(
                category -> toDto(category)
        ).collect(Collectors.toList());
    }
}
