package com.solomon.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solomon.springcloud.model.Products;

public interface ProductRepo extends JpaRepository<Products, Long> {

}
