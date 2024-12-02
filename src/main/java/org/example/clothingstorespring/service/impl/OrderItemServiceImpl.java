package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.model.OrderItem;
import org.example.clothingstorespring.repository.ClothingItemRepository;
import org.example.clothingstorespring.repository.OrderItemRepository;
import org.example.clothingstorespring.repository.OrderRepository;
import org.example.clothingstorespring.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {


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


    @Override
    public List<OrderItem> createOrderItems(List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getOrder() == null || orderItem.getOrder().getId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order cannot be null");
            }

            // Перевірка, чи існує замовлення
            if (!orderRepository.existsById(orderItem.getOrder().getId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not found for item: " + orderItem);
            }

            // Перевірка, чи існує товар
            if (orderItem.getClothingItem() == null || orderItem.getClothingItem().getId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Clothing item cannot be null");
            }

            if (!clothingItemRepository.existsById(orderItem.getClothingItem().getId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Clothing item not found for item: " + orderItem);
            }
        }

        return orderItemRepository.saveAll(orderItems);
    }
}