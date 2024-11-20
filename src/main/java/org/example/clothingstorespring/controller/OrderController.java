package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.dto.OrderDTO;
import org.example.clothingstorespring.dto.OrderResponseDTO;
import org.example.clothingstorespring.dto.PaymentDTO;
import org.example.clothingstorespring.dto.PaymentResponseDTO;
import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.model.OrderRequest;
import org.example.clothingstorespring.model.Payment;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        try {
            Order createdOrder = orderService.createOrder(orderDTO);
            logger.info("Order created successfully: {}", createdOrder);

            OrderResponseDTO responseDTO = mapToResponseDTO(createdOrder);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } catch (IllegalArgumentException e) {
            logger.error("Invalid input: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            logger.error("Error creating order: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private OrderResponseDTO mapToResponseDTO(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setCustomerName(order.getCustomerName());
        dto.setTotal(order.getTotal());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus());
        return dto;
    }
}