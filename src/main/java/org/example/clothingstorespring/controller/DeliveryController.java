package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.dto.DeliveryDTO;
import org.example.clothingstorespring.dto.DeliveryResponseDTO;
import org.example.clothingstorespring.model.Delivery;
import org.example.clothingstorespring.service.impl.DeliveryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    public DeliveryController(DeliveryServiceImpl deliveryService) {
        this.deliveryService = deliveryService;
    }

    private final DeliveryServiceImpl deliveryService;
    private static final Logger logger = LoggerFactory.getLogger(DeliveryController.class);

    @PostMapping("/createDelivery")
    public ResponseEntity<DeliveryResponseDTO> createDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        try {
            Delivery createdDelivery = deliveryService.createDelivery(deliveryDTO);
            logger.info("Delivery created successfully: {}", createdDelivery);

            DeliveryResponseDTO responseDTO = mapToResponseDTO(createdDelivery);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } catch (IllegalArgumentException e) {
            logger.error("Invalid input: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            logger.error("Error creating delivery: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private DeliveryResponseDTO mapToResponseDTO(Delivery delivery) {
        DeliveryResponseDTO dto = new DeliveryResponseDTO();
        dto.setId(delivery.getId());
        dto.setOrderId(delivery.getOrder().getId());
        dto.setDeliveryAddress(delivery.getDeliveryAddress());
        dto.setDeliveryDate(delivery.getDeliveryDate());
        dto.setStatus(delivery.getStatus());
        dto.setDeliveryType(delivery.getDeliveryType());
        return dto;
    }


    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) {
        Delivery delivery = deliveryService.getDeliveryById(id);
        return delivery != null ? ResponseEntity.ok(delivery) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<Delivery> getDeliveryByOrderId(@PathVariable Long orderId) {
        deliveryService.findByOrderId(orderId);
        return ResponseEntity.ok(deliveryService.findByOrderId(orderId));
    }

}