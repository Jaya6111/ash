package com.rs.app.request;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String pId;

	
    @NotBlank(message = "Booktitle is required")
	private String bookTitle;
	
    @NotNull(message = "Author cannot be null")
	private String author;
	
    @NotNull(message = "descrption cannot be null")
	private String description;
	
    @NotNull(message = "language cannot be null")
	private String language;
	
    @NotBlank(message = "uId name is required")
	private String uId;

}
