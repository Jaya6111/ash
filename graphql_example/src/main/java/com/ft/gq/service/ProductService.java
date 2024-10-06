package com.ft.gq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ft.gq.entity.Product;
import com.ft.gq.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public List<Product> getProductsByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	public Product updateStock(int id, int stock) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("product not found with id: " + id));
		existingProduct.setStock(stock);
		return productRepository.save(existingProduct);
	}

	public Product receiveNewShipment(int id, int quantity) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("product not found with id: " + id));
		existingProduct.setStock(existingProduct.getStock() + quantity);
		return productRepository.save(existingProduct);
	}

}
