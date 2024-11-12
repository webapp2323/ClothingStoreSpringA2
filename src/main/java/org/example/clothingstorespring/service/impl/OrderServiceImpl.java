package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.model.OrderRequest;
import org.example.clothingstorespring.model.OrderStatus;
import org.example.clothingstorespring.repository.OrderRepository;
import org.example.clothingstorespring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Order createOrder(OrderRequest orderRequest) {


        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setTotal(orderRequest.getTotalAmount());
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.valueOf("PENDING"));


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
        order.setStatus(OrderStatus.valueOf(status));
        orderRepository.save(order);
    }
}