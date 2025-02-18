package org.example.clothingstorespring.service;

import org.example.clothingstorespring.dto.OrderItemDTO;
import org.example.clothingstorespring.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItemDTO> getAllOrderItems();

    List<OrderItemDTO> createOrderItems(List<OrderItem> orderItems);

    OrderItemDTO getOrderItemById(Long id);
}