package org.example.clothingstorespring.repository;

import org.example.clothingstorespring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
