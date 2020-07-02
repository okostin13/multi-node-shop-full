package com.kostinshmatova.backend.service;

import com.kostinshmatova.backend.dto.CategoryDto;
import com.kostinshmatova.backend.dto.OrderDto;
import com.kostinshmatova.backend.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final static String URL = "http://order-service/";

    private final RestTemplate restTemplate;

    @Autowired
    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OrderDto getById(Long id) {
        return restTemplate.getForObject(URL + "order/" + id, OrderDto.class);
    }

    public List<OrderDto> getByPurchaserName(String purchaserName) {
        Map<String, String> params = new HashMap<>();
        params.put("purchaserName", purchaserName);
        List<OrderDto> orders = restTemplate.getForObject(URL+"order?purchaserName={purchaserName}", List.class, params);
        return orders;
    }

    public Long createOrder(OrderDto order) {
        return restTemplate.postForObject(URL + "order", order, Long.class);
    }

}
