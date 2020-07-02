package com.kostinshmatova.productservice.mapper;

import com.kostinshmatova.productservice.dto.CategoryDto;
import com.kostinshmatova.productservice.entity.Category;

public class CategoryMapper {

    public static CategoryDto toDto(Category category){
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}
