package com.rs.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rs.app.bean.Book;
import com.rs.app.request.AddBookRequest;

public interface BookService {

	public String uploadBook(MultipartFile file, AddBookRequest request) throws IOException;
	
	public byte[] getbookById(String pId);

	public byte[] getBookByTitle(String bookTitle);

	public byte[] getBookByAuthor(String author);

	public List<Book> getSearch(String searchParam);

	public Book getBookByById(String id);

	public String userId();
	


}
