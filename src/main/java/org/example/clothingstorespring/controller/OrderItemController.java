package org.example.clothingstorespring.controller;

import org.example.clothingstorespring.dto.OrderItemDTO;
import org.example.clothingstorespring.model.OrderItem;
import org.example.clothingstorespring.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;


    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    // Отримати всі OrderItems
    @GetMapping
    public List<OrderItemDTO> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    // Отримати OrderItem за ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable Long id) {
        OrderItemDTO orderItem = orderItemService.getOrderItemById(id);
        return orderItem != null ? ResponseEntity.ok(orderItem) : ResponseEntity.notFound().build();
    }

    // Додати нові OrderItems
    @PostMapping
    public ResponseEntity<List<OrderItemDTO>> createOrderItems(@RequestBody List<OrderItem> orderItems) {
        List<OrderItemDTO> createdOrderItems = orderItemService.createOrderItems(orderItems);
        return ResponseEntity.status(201).body(createdOrderItems);
    }
}