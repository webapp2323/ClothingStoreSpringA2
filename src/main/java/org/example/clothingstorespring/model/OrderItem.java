package org.example.clothingstorespring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Table(name = "order_items")
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clothing_item_id", nullable = false)
    private ClothingItem clothingItem;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonBackReference
    private Order order;


    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "status", nullable = false)
    private String status;
}


