package org.example.clothingstorespring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Table(name = "order_items")
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Зв'язок з ClothingItem
    @JoinColumn(name = "clothing_item_id", nullable = false)
    private ClothingItem clothingItem;

    private Integer quantity;

    @ManyToOne // Зв'язок з Order
    @JoinColumn(name = "order_id", nullable = false)
    @JsonBackReference
    private Order order;

    // Ви можете додати поле для ціни, якщо потрібно
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice; // Додайте поле для ціни
}


