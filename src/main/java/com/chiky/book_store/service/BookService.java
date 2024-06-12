package com.chiky.book_store.service;

import com.chiky.book_store.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book create (Book book);
    List<Book> getAll(Integer price);
    Book getBookById(String id);
//    List<Book> getBooksByPriceLessThan(Integer price);
    Book update (Book book);

}
