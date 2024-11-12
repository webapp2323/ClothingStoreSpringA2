package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.model.OrderRequest;
import org.example.clothingstorespring.model.PaymentResponse;
import org.example.clothingstorespring.service.OrderService;
import org.example.clothingstorespring.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    private OrderService orderService;
    private PaymentService paymentService;

    public OrderController(OrderService orderService, PaymentService paymentService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
    }


    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        // Створення замовлення
        Order order = orderService.createOrder(orderRequest);

        // Обробка платежу
        PaymentResponse paymentResponse = paymentService.processPayment(order);

        if (paymentResponse.isSuccessful()) {
            orderService.updateOrderStatus(order.getId(), "PAID");
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        } else {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(null);
        }
    }
}