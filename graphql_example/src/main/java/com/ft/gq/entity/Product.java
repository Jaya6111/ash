package com.ft.gq.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String category;
	private Float price;
	private Integer stock;

	public Product(String name, String category, Float price, Integer stock) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

}
