package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.model.OrderItem;
import org.example.clothingstorespring.repository.ClothingItemRepository;
import org.example.clothingstorespring.repository.OrderItemRepository;
import org.example.clothingstorespring.repository.OrderRepository;
import org.example.clothingstorespring.service.OrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private static final Logger logger = LoggerFactory.getLogger(OrderItemServiceImpl.class);

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClothingItemRepository clothingItemRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Transactional
    @Override
    public List<OrderItem> createOrderItems(List<OrderItem> orderItems) {
        if (orderItems == null || orderItems.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order items list cannot be null or empty");
        }

        for (OrderItem orderItem : orderItems) {
            if (orderItem.getOrder() == null || orderItem.getOrder().getId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order cannot be null");
            }

            // Проверка существования заказа
            if (!orderRepository.existsById(orderItem.getOrder().getId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not found for item: " + orderItem);
            }

            // Проверка существования товара
            if (orderItem.getClothingItem() == null || orderItem.getClothingItem().getId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Clothing item cannot be null");
            }

            if (!clothingItemRepository.existsById(orderItem.getClothingItem().getId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Clothing item not found for item: " + orderItem);
            }
        }

        logger.info("Creating order items: {}", orderItems);
        return orderItemRepository.saveAll(orderItems);
    }
}