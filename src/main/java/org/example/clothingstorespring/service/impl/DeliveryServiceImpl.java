package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.model.Delivery;
import org.example.clothingstorespring.model.DeliveryType;
import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.repository.DeliveryRepository;
import org.example.clothingstorespring.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    // Конструктор для ін'єкції залежностей
    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    // Створює нову доставку в базі даних
    @Override
    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery); // Зберігає доставку в базі даних
    }

    // Повертає список усіх доставок
    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll(); // Отримує всі доставки
    }

    // Повертає доставку за ID
    @Override
    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).orElse(null); // Повертає доставку або null, якщо не знайдено
    }

    // Оновлює інформацію про доставку
    @Override
    public void updateDelivery(Delivery delivery) {
        deliveryRepository.save(delivery); // Зберігає оновлену доставку
    }

    // Видаляє доставку за ID
    @Override
    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id); // Видаляє доставку з бази даних
    }

    @Override
    public Delivery findByOrderId(Long orderId) {
        return deliveryRepository.findByOrderId(orderId);
    }

    @Override
    public List<Delivery> findAllByOrder(Order order) {
        return deliveryRepository.findAllByOrder(order);
    }

    @Override
    public List<Delivery> findAllByDeliveryType(DeliveryType deliveryType) {
        return deliveryRepository.findAllByDeliveryType(deliveryType);
    }
}