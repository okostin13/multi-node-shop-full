package com.kostinshmatova.backend.service;

import com.kostinshmatova.backend.dto.CategoryDto;
import com.kostinshmatova.backend.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private final static String URL = "http://product-service/";

    private final RestTemplate restTemplate;

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDto> getByCategoryId(Long categoryId) {
        Map<String, String> params = new HashMap<>();
        params.put("categoryId", categoryId.toString());
        List<ProductDto> products = restTemplate.getForObject(URL + "product?categoryId={categoryId}", List.class, params);
        return products;
    }

    public ProductDto getById(Long id){
        return restTemplate.getForObject(URL +"product/"+ id, ProductDto.class);
    }

    public List<CategoryDto> getAllCategories() {
        return restTemplate.getForObject(URL + "category", List.class);
    }

}
