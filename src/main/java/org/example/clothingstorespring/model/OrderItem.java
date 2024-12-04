package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Table(name = "order_items")
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private Integer quantity;

    @ManyToOne // Предполагается, что OrderItem связан с ClothingItem
    @JoinColumn(name = "clothing_item_id", nullable = false) // Укажите соответствующий внешний ключ
    private ClothingItem clothingItem; // Добавьте это поле

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}


