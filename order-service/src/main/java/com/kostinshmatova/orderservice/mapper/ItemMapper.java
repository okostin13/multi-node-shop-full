package com.kostinshmatova.orderservice.mapper;

import com.kostinshmatova.orderservice.dto.ItemDto;
import com.kostinshmatova.orderservice.entity.Item;
import com.kostinshmatova.orderservice.entity.Order;

public class ItemMapper {

    public static ItemDto toDto(Item item){
        ItemDto dto = new ItemDto();
        dto.setId(item.getId());
        dto.setProductId(item.getProductId());
        dto.setOrderId(item.getOrder().getId());
        return dto;
    }

    public static Item toEntity(ItemDto itemDto, Order order){
        Item entity = new Item();
        entity.setId(itemDto.getId());
        entity.setProductId(itemDto.getProductId());
        entity.setOrder(order);
        return entity;
    }
}
