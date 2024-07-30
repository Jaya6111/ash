package com.rs.app.feign;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.rs.app.bean.Product;

@Component
public class ConnectBookServiceFallback implements ConnectBookService {

    @Override
    public ResponseEntity<Product> getProductById(String id) {
    	return new ResponseEntity<Product>(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
