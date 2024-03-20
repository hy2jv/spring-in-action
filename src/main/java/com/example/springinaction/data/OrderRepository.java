package com.example.springinaction.data;

import com.example.springinaction.Order;

public interface OrderRepository {
    Order save(Order order);
}
