package com.rs.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.rs.app.bean.Book;

@EnableMongoRepositories
@Repository
public interface BookRepository extends MongoRepository<Book, String> {

	List<Book> findByAuthor(String author);

	List<Book> findByBookTitle(String title);

	List<Book> findByDescription(String description);

	List<Book> findByLanguage(String language);

	List<Book> findByuId(String uid);

	List<Book> findByBookTitleContainingOrAuthorContainingOrLanguageContaining(String bookTitle, String author,
			String language);
}
