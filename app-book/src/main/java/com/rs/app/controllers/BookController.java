package com.rs.app.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rs.app.bean.Book;
import com.rs.app.repositories.BookRepository;
import com.rs.app.request.AddBookRequest;
import com.rs.app.service.BookService;

@RestController
@RequestMapping("/book")
@Validated
public class BookController {

	public final BookRepository bookRepository;

	@Autowired
	private BookService bookService;

	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@PostMapping
	public ResponseEntity<?> uploadBook(@RequestParam("book") MultipartFile file,
			@ModelAttribute AddBookRequest request) throws IOException {
		String uploadImage = bookService.uploadBook(file, request);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	@GetMapping("/{pId}")
	public ResponseEntity<?> getBookById(@PathVariable String pId) {

		try {
			byte[] book = bookService.getbookById(pId);
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_PDF)
					.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + pId + "\"").body(book);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found with name " + pId);
		}
	}

	@GetMapping("/{bookTitle}")
	public ResponseEntity<?> getBookByBookTitle(@PathVariable String bookTitle) {

		try {
			byte[] book = bookService.getbookById(bookTitle);
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_PDF)
					.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + bookTitle + "\"").body(book);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found with name " + bookTitle);
		}
	}

	@GetMapping("/{author}")
	public ResponseEntity<Book> getBookByAuthor(@PathVariable String author) {

		List<Book> books = bookRepository.findByAuthor(author);

		if (!books.isEmpty() && books != null) {

			return new ResponseEntity<Book>(books.get(0), HttpStatus.OK);

		} else {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);

		}
	}

	@GetMapping("/search ")
	public ResponseEntity<List<Book>> getSearch(@RequestParam String searchParam) {

		List<Book> books = bookService.getSearch(searchParam);

		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);

	}

	@GetMapping("/userId")
	public String userId() {
		return bookService.userId();
	}

}
