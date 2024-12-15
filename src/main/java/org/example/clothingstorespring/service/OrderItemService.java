package org.example.clothingstorespring.service;

import org.example.clothingstorespring.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();

    List<OrderItem> createOrderItems(List<OrderItem> orderItems);

    OrderItem getOrderItemById(Long id);
}