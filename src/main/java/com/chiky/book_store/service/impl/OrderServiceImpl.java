package com.chiky.book_store.service.impl;

import com.chiky.book_store.entity.Book;
import com.chiky.book_store.entity.Customer;
import com.chiky.book_store.entity.Orders;
import com.chiky.book_store.repository.OrderRepository;
import com.chiky.book_store.service.BookService;
import com.chiky.book_store.service.CustomerService;
import com.chiky.book_store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final BookService bookService;

    @Override
    public Orders createOrder(Orders order) {
        Customer customer = customerService.getById(order.getCustomer().getId());
        List<Book> books = order.getBooks().stream()
                .map(book -> bookService.getBookById(book.getId())).toList();

        Orders newOrder = Orders.builder()
                .customer(customer)
                .books(books)
                .qty(order.getQty())
                .build();
        return orderRepository.saveAndFlush(newOrder);
    }

    @Override
    public List<Orders> getAll() {
        List<Orders> orders = orderRepository.findAll();
        return orders;
    }
}
