package com.kostinshmatova.orderservice.controller;

import com.kostinshmatova.orderservice.dao.ItemDao;
import com.kostinshmatova.orderservice.dao.OrderDao;
import com.kostinshmatova.orderservice.dto.OrderDto;
import com.kostinshmatova.orderservice.entity.Item;
import com.kostinshmatova.orderservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.kostinshmatova.orderservice.mapper.OrderMapper.toDto;
import static com.kostinshmatova.orderservice.mapper.OrderMapper.toEntity;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderDao orderDao;
    private final ItemDao itemDao;

    @Autowired
    public OrderController(OrderDao orderDao, ItemDao itemDao) {
        this.orderDao = orderDao;
        this.itemDao = itemDao;
    }

    @PostMapping
    public Long createOrder(@RequestBody OrderDto order) {
        Order orderEntity = toEntity(order);
        orderDao.save(orderEntity);
        List<Item> items = order.getItems().stream().map(
                item-> com.kostinshmatova.orderservice.mapper.ItemMapper.toEntity(item,orderEntity)
        ).collect(Collectors.toList());
        itemDao.saveAll(items);
        return orderEntity.getId();
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        return toDto(orderDao.getOne(id));
    }

    @GetMapping
    public List<OrderDto> getOrdersByPurchaserName(@RequestParam String purchaserName) {
        return orderDao.findByPurchaserName(purchaserName)//.sort((order1,order2)->order1.getStatus().equals("Done")?1:-1);
                .stream().map(order -> toDto(order))
                .collect(Collectors.toList());
    }

}
