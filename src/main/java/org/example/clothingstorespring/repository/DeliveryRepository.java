package org.example.clothingstorespring.repository;

import org.example.clothingstorespring.model.Delivery;
import org.example.clothingstorespring.model.DeliveryType;
import org.example.clothingstorespring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Delivery findByOrderId(Long orderId);

    List<Delivery> findAllByOrder(Order order);
    List<Delivery> findAllByDeliveryType(DeliveryType deliveryType);
}

