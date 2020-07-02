package com.kostinshmatova.productservice.dao;

import com.kostinshmatova.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Long> {

    List<Product> findByCategory_Id(Long categoryId);
}
