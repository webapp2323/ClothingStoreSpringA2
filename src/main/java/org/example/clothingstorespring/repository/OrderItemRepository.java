package org.example.clothingstorespring.repository;

import org.example.clothingstorespring.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // Додаткові методи запитів можна визначити тут, якщо потрібно
}