package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.model.OrderRequest;
import org.example.clothingstorespring.repository.OrderRepository;
import org.example.clothingstorespring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository; // Ін'єкція OrderRepository

    @Override
    @Transactional
    public Order createOrder(OrderRequest orderRequest) {

        // Створення нового замовлення
        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setTotal(orderRequest.getTotalAmount()); // Переконайтеся, що назва методу правильна
        order.setOrderDate(LocalDateTime.now()); // Встановлення дати замовлення
        order.setStatus("PENDING"); // Статус за замовчуванням

        // Збереження замовлення в базі даних
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public void updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + orderId));
        order.setStatus(status);
        orderRepository.save(order);
    }
}