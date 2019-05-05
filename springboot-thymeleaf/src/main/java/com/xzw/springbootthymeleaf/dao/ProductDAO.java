package com.xzw.springbootthymeleaf.dao;

import com.xzw.springbootthymeleaf.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {
}
