package org.example.clothingstorespring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class OrderRequest {
    private String customerName;  // Ім'я клієнта
    private BigDecimal totalAmount; // Загальна сума замовлення
    private Long storeId; // Ідентифікатор магазину (якщо потрібно)
    private Long userId; // Ідентифікатор користувача (якщо потрібно)
    @Id
    private Long id;

}
