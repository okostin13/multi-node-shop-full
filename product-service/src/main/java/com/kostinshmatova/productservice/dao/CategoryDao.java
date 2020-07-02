package com.kostinshmatova.productservice.dao;

import com.kostinshmatova.productservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {
}
