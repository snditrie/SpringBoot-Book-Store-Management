package com.chiky.book_store.service;

import com.chiky.book_store.entity.Orders;

import java.util.List;

public interface OrderService {
    Orders createOrder(Orders order);
    List<Orders> getAll();
}
