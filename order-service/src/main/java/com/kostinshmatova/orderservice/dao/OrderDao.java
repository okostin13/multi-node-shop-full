package com.kostinshmatova.orderservice.dao;

import com.kostinshmatova.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order,Long> {

    List<Order> findByPurchaserName(String name);
}
