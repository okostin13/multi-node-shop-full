package com.kostinshmatova.orderservice.dao;

import com.kostinshmatova.orderservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item,Long> {
}
