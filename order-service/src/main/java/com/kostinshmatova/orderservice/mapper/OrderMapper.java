package com.kostinshmatova.orderservice.mapper;

import com.kostinshmatova.orderservice.dto.OrderDto;
import com.kostinshmatova.orderservice.entity.Order;

import java.util.stream.Collectors;

import static com.kostinshmatova.orderservice.mapper.ItemMapper.toDto;

public class OrderMapper {

    public static OrderDto toDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setAddress(order.getAddress());
        dto.setPurchaserName(order.getPurchaserName());
        dto.setStatus(order.getStatus());
        dto.setItems(
                order.getItems().stream().map(
                        item -> com.kostinshmatova.orderservice.mapper.ItemMapper.toDto(item)
                ).collect(Collectors.toList())
        );
        return dto;
    }

    public static Order toEntity(OrderDto dto) {
        Order entity = new Order();
        entity.setId(dto.getId());
        entity.setAddress(dto.getAddress());
        entity.setPurchaserName(dto.getPurchaserName());
        entity.setStatus(dto.getStatus());
        /*entity.setItems(dto.getItems().stream().map(
                itemDto -> com.kostinshmatova.orderservice.mapper.ItemMapper.toEntity(itemDto,entity)
        ).collect(Collectors.toList()));*/
        return entity;
    }
}
