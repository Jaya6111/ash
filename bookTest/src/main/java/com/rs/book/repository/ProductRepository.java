package com.rs.book.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rs.book.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	
	@Query(value = "{}", fields = "{'_place': 0, '_id': 0}")
	List<Product> findAllExcludingPlaceAndId();

}
