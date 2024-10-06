package com.ft.gq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ft.gq.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByCategory(String category);
}
