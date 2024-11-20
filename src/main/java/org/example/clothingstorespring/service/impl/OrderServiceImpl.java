package org.example.clothingstorespring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.clothingstorespring.dto.OrderDTO;
import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.model.OrderRequest;
import org.example.clothingstorespring.model.OrderStatus;
import org.example.clothingstorespring.repository.OrderRepository;
import org.example.clothingstorespring.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private final OrderRepository orderRepository;


    @Override
    public Order createOrder(OrderDTO orderDTO) {
        if (orderDTO.getUser() == null || orderDTO.getUser().getId() == null) {
            throw new IllegalArgumentException("User must not be null");
        }

        Order order = new Order();
        order.setCustomerName(orderDTO.getCustomerName());
        order.setTotal(orderDTO.getTotal());
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);


        order.setUser(orderDTO.getUser());

        return orderRepository.save(order);
    }

    @Transactional
    @Override
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

    @Override
    public Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + orderId));
    }
}