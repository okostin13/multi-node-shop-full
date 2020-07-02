package com.kostinshmatova.backend.controller;

import com.kostinshmatova.backend.dto.OrderDto;
import com.kostinshmatova.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Long createOrder(@RequestBody OrderDto order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @GetMapping
    public List<OrderDto> getOrdersByPurchaserName(@RequestParam String purchaserName) {
        return orderService.getByPurchaserName(purchaserName);
    }

}
