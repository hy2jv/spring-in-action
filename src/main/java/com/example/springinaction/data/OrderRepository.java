package com.example.springinaction.data;

import com.example.springinaction.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
