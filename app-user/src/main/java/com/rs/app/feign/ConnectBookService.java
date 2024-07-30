package com.rs.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rs.app.bean.Product;

//@FeignClient(name = "BOOK-SERVICE", fallback = ConnectBookServiceFallback.class)
@FeignClient("BOOK-SERVICE")
public interface ConnectBookService {

	@GetMapping("/book/getbook/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String id);
}
