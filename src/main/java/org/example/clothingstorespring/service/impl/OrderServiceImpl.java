package org.example.clothingstorespring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.clothingstorespring.dto.DeliveryDTO;
import org.example.clothingstorespring.dto.OrderDTO;
import org.example.clothingstorespring.dto.PaymentDTO;
import org.example.clothingstorespring.model.*;
import org.example.clothingstorespring.repository.OrderRepository;
import org.example.clothingstorespring.service.ClothingItemService;
import org.example.clothingstorespring.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ClothingItemService clothingItemService;

    public OrderServiceImpl(OrderRepository orderRepository, ClothingItemService clothingItemService) {
        this.orderRepository = orderRepository;
        this.clothingItemService = clothingItemService;
    }

    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        if (orderDTO.getUser() == null || orderDTO.getUser().getId() == null) {
            throw new IllegalArgumentException("User must not be null");
        }

        Order order = convertToOrder(orderDTO);


        orderRepository.save(order);


        PaymentDTO paymentDTO = orderDTO.getPayment();
        if (paymentDTO != null) {
            Payment payment = new Payment();
            payment.setAmount(paymentDTO.getAmount());
            payment.setMethod(paymentDTO.getMethod());
            payment.setPaymentDate(paymentDTO.getPaymentDate());
            payment.setOrder(order);
            order.setPayment(payment);
        }


        DeliveryDTO deliveryDTO = orderDTO.getDelivery();
        if (deliveryDTO != null) {
            Delivery delivery = new Delivery();
            delivery.setDeliveryAddress(deliveryDTO.getDeliveryAddress());
            delivery.setDeliveryDate(deliveryDTO.getDeliveryDate());
            delivery.setStatus(deliveryDTO.getStatus());
            delivery.setDeliveryType(deliveryDTO.getDeliveryType());
            delivery.setOrder(order);
            order.setDelivery(delivery);
        }

        return orderRepository.save(order);
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        return null;
    }

    public Order convertToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomerName(orderDTO.getCustomerName());
        order.setTotal(orderDTO.getTotal());
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);
        order.setUser(orderDTO.getUser());


        List<OrderItem> orderItems = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : orderDTO.getItems().entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setClothingItem(clothingItemService.findById(entry.getKey())); //
            orderItem.setQuantity(entry.getValue());
            orderItems.add(orderItem);
        }
        order.setItems(orderItems);
        return order;
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
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + orderId));
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }
}