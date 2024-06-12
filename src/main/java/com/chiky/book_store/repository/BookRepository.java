package com.chiky.book_store.repository;

import com.chiky.book_store.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    @Query(value = "SELECT * FROM Book WHERE price < ?1", nativeQuery = true)
    List<Book> findBooksByPriceLessThan (Integer price);
}
