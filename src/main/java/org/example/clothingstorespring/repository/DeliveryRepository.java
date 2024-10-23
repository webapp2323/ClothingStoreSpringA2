package org.example.clothingstorespring.repository;

import org.example.clothingstorespring.model.Delivery;
import org.example.clothingstorespring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}

