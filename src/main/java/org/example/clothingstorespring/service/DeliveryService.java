package org.example.clothingstorespring.service;



import org.example.clothingstorespring.model.Delivery;

import java.util.List;

public interface DeliveryService {
    Delivery createDelivery(Delivery delivery);
    List<Delivery> getAllDeliveries();
    Delivery getDeliveryById(Long id);
    void updateDelivery(Delivery delivery);
    void deleteDelivery(Long id);
}