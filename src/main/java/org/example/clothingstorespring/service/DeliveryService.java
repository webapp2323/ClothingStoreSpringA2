package org.example.clothingstorespring.service;



import org.example.clothingstorespring.dto.DeliveryDTO;
import org.example.clothingstorespring.model.Delivery;
import org.example.clothingstorespring.model.DeliveryType;
import org.example.clothingstorespring.model.Order;

import java.util.List;

public interface DeliveryService {
    Delivery createDelivery(DeliveryDTO delivery);
    List<Delivery> getAllDeliveries();
    Delivery getDeliveryById(Long id);
    void updateDelivery(Delivery delivery);
    void deleteDelivery(Long id);
    Delivery findByOrderId(Long orderId);
    List<Delivery> findAllByOrder(Order order);
    List<Delivery> findAllByDeliveryType(DeliveryType deliveryType);

}