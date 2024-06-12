package com.chiky.book_store.service.impl;

import com.chiky.book_store.constant.ResponseMessage;
import com.chiky.book_store.entity.Book;
import com.chiky.book_store.repository.BookRepository;
import com.chiky.book_store.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    final private BookRepository bookRepository;

    @Override
    public Book create(Book book) {
//        if(!book.getIsbn().isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ResponseMessage.ERROR_ALREADY_EXIST);
//        }
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> getAll(Integer price) {
        if(price == null) {
            return bookRepository.findAll();

        } else {
            return bookRepository.findBooksByPriceLessThan(price);
        }
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ResponseMessage.ERROR_NOT_FOUND));
    }

//    @Override
//    public List<Book> getBooksByPriceLessThan(Integer price) {
//        List<Book> books = bookRepository.findBooksByPriceLessThan(price);
//        if(books.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ResponseMessage.ERROR_NOT_FOUND);
//        }
//        return books;
//    }

    @Override
    public Book update(Book book) {
        Book bookToUpdate = bookRepository.findById(book.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ResponseMessage.ERROR_NOT_FOUND));
        return bookRepository.saveAndFlush(bookToUpdate);
    }
}
