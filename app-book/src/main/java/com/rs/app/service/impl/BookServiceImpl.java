package com.rs.app.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rs.app.bean.Book;
import com.rs.app.feign.ConnectUserService;
import com.rs.app.repositories.BookRepository;
import com.rs.app.request.AddBookRequest;
import com.rs.app.service.BookService;
import com.rs.app.util.BookUtil;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	/*
	 * @Autowired private PdfRepository pdfRepository;
	 */

	@Autowired
	private ConnectUserService connectUserService;

	private Book setbook(AddBookRequest request) throws FileNotFoundException {
		Book book = new Book();

		if (request != null) {
			book.setPId(request.getPId());
			book.setBookTitle(request.getBookTitle());
			book.setAuthor(request.getAuthor());
			book.setDescription(request.getDescription());
			book.setLanguage(request.getLanguage());
			book.setUId(request.getUId());

		}
		return book;
	}
	
	@Override
	public String uploadBook(MultipartFile file, AddBookRequest request) throws IOException {
		
		Book book = setbook(request);
		book.setPdf(BookUtil.compressImage(file.getBytes()));
		Book bookData = bookRepository.save(book);
		if (bookData != null) {
			return "file uploaded successfully : " + file.getOriginalFilename();
		}
		return null;
	}
	
	@Override
	public byte[] getbookById(String pId) {
		Optional<Book> books = bookRepository.findById(pId);
		return BookUtil.decompressImage(books.get().getPdf());
	}
	
	@Override
	public byte[] getBookByTitle(String bookTitle) {
		Optional<Book> books = bookRepository.findById(bookTitle);
		return BookUtil.decompressImage(books.get().getPdf());
	}
	
	@Override
	public byte[] getBookByAuthor(String author) {

		Optional<Book> books = bookRepository.findById(author);
		return BookUtil.decompressImage(books.get().getPdf());
	}

	public List<Book> getSearch(String searchParam) {

		List<Book> books = bookRepository.findByBookTitleContainingOrAuthorContainingOrLanguageContaining(searchParam,
				searchParam, searchParam);

		return books;
	}

	@Override
	public Book getBookByById(String id) {
		Optional<Book> op = bookRepository.findById(id);
		return op.get();
	}

	@Override
	public String userId() {
		String userId = connectUserService.userId();
		return userId;
	}

}
