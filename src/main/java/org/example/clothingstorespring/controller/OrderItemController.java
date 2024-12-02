package org.example.clothingstorespring.controller;

import org.example.clothingstorespring.model.OrderItem;
import org.example.clothingstorespring.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    // Отримати всі OrderItems
    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    // Додати нові OrderItems
    @PostMapping
    public ResponseEntity<List<OrderItem>> createOrderItems(@RequestBody List<OrderItem> orderItems) {
        List<OrderItem> createdOrderItems = orderItemService.createOrderItems(orderItems);
        return ResponseEntity.status(201).body(createdOrderItems);
    }
}