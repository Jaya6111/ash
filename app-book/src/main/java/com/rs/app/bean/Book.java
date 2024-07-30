package com.rs.app.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "product")
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Book {
	@Id
	private String pId;

	@Field
	private String bookTitle;

	@Field
	private String author;
	@Field
	private String description;
	@Field
	private String language;
	@Field
	private String uId;
	@Field
	private String category;
	@Field
	private byte[] pdf;

	public Book() {
	}

	public Book(String bookTitle, String author, String description, String language, String file, String uId) {

		this.bookTitle = bookTitle;
		this.author = author;
		this.description = description;
		this.language = language;
		this.uId = uId;

	}

}
