package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.dto.DeliveryDTO;
import org.example.clothingstorespring.dto.OrderDTO;
import org.example.clothingstorespring.model.*;
import org.example.clothingstorespring.repository.DeliveryRepository;
import org.example.clothingstorespring.service.DeliveryService;
import org.example.clothingstorespring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final OrderService orderService;
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryServiceImpl(OrderService orderService, DeliveryRepository deliveryRepository) {
        this.orderService = orderService;
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Delivery createDelivery(DeliveryDTO deliveryDTO) {
        // Your implementation logic here
        if (deliveryDTO == null) {
            throw new IllegalArgumentException("DeliveryDTO cannot be null");
        }

        if (deliveryDTO.getOrderId() == null) {
            throw new IllegalArgumentException("Order ID cannot be null");
        }

        // Fetch order by ID
        Order order = orderService.findOrderById(deliveryDTO.getOrderId());
        if (order == null) {
            throw new IllegalArgumentException("Order not found for ID: " + deliveryDTO.getOrderId());
        }

        // Create a new Delivery entity
        Delivery delivery = new Delivery();
        delivery.setOrder(order);
        delivery.setDeliveryAddress(deliveryDTO.getDeliveryAddress());
        delivery.setDeliveryDate(deliveryDTO.getDeliveryDate());
        delivery.setStatus(DeliveryStatus.valueOf(deliveryDTO.getStatus().toUpperCase()));
        delivery.setDeliveryType(DeliveryType.valueOf(deliveryDTO.getDeliveryType().toUpperCase()));

        // Save the Delivery entity
        return deliveryRepository.save(delivery);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return List.of();
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        return null;
    }

    @Override
    public void updateDelivery(Delivery delivery) {

    }

    @Override
    public void deleteDelivery(Long id) {

    }

    @Override
    public Delivery findByOrderId(Long orderId) {
        return null;
    }

    @Override
    public List<Delivery> findAllByOrder(Order order) {
        return List.of();
    }

    @Override
    public List<Delivery> findAllByDeliveryType(DeliveryType deliveryType) {
        return List.of();
    }
}
    // Повертає список усіх доставок
//    @Override
//    public List<Delivery> getAllDeliveries() {
//        return deliveryRepository.findAll(); // Отримує всі доставки
//    }
//
//    // Повертає доставку за ID
//    @Override
//    public Delivery getDeliveryById(Long id) {
//        return deliveryRepository.findById(id).orElse(null); // Повертає доставку або null, якщо не знайдено
//    }
//
//    // Оновлює інформацію про доставку
//    @Override
//    public void updateDelivery(Delivery delivery) {
//        deliveryRepository.save(delivery); // Зберігає оновлену доставку
//    }
//
//    // Видаляє доставку за ID
//    @Override
//    public void deleteDelivery(Long id) {
//        deliveryRepository.deleteById(id); // Видаляє доставку з бази даних
//    }
//
//    @Override
//    public Delivery findByOrderId(Long orderId) {
//        return deliveryRepository.findByOrderId(orderId);
//    }
//
//    @Override
//    public List<Delivery> findAllByOrder(Order order) {
//        return deliveryRepository.findAllByOrder(order);
//    }
//
//    @Override
//    public List<Delivery> findAllByDeliveryType(DeliveryType deliveryType) {
//        return deliveryRepository.findAllByDeliveryType(deliveryType);
//    }
