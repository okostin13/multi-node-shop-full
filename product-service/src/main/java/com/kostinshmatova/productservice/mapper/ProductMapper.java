package com.kostinshmatova.productservice.mapper;

import com.kostinshmatova.productservice.dto.ProductDto;
import com.kostinshmatova.productservice.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategoryId(product.getCategory().getId());
        return dto;
    }
}
