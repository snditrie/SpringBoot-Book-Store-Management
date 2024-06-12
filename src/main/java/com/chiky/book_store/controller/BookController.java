package com.chiky.book_store.controller;

import com.chiky.book_store.constant.APIUrl;
import com.chiky.book_store.constant.ResponseMessage;
import com.chiky.book_store.entity.Book;
import com.chiky.book_store.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.BOOK_API)
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        Book newBook = bookService.create(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @GetMapping(path = APIUrl.PATH_VAR_ID)
    public ResponseEntity<Book> showBookById(@PathVariable String id) {
        Book bookById = bookService.getBookById(id);
        return ResponseEntity.ok(bookById);
    }

    @GetMapping
    public ResponseEntity<List<Book>> showAllBook (
            @RequestParam(name = "price", required = false) Integer price
    ) {
        List<Book> books = bookService.getAll(price);
        return ResponseEntity.ok(books);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updateBook = bookService.update(book);
        return ResponseEntity.ok(updateBook);
    }
}
