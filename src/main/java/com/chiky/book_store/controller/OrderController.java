package com.chiky.book_store.controller;

import com.chiky.book_store.constant.APIUrl;
import com.chiky.book_store.entity.Orders;
import com.chiky.book_store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.ORDER_API)
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Orders> addNewOrder(@RequestBody Orders order) {
        Orders newOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }

    @GetMapping
    public ResponseEntity<List<Orders>> showAllOrder() {
        List<Orders> allOrders = orderService.getAll();
        return ResponseEntity.ok(allOrders);
    }
}
