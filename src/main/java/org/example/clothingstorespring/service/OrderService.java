package org.example.clothingstorespring.service;

import org.example.clothingstorespring.dto.OrderDTO;
import org.example.clothingstorespring.dto.PaymentDTO;
import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.model.OrderRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderDTO orderDTO);

    @Transactional
    Order createOrder(OrderRequest orderRequest);

    List<Order> getAllOrders();
    void updateOrderStatus(Long orderId, String status);
    Order findOrderById(Long Id);
    void deleteOrder(Order order);
}

