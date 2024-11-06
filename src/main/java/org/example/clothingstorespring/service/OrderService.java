package org.example.clothingstorespring.service;

import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.model.OrderRequest;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderRequest orderRequest);
    List<Order> getAllOrders();
    void updateOrderStatus(Long orderId, String status);
}

