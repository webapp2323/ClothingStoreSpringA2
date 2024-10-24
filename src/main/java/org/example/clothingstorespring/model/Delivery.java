package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // Зв'язок з сутністю Order

    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Enumerated(EnumType.STRING) // Зберігає значення як рядок
    @Column(name = "status", nullable = false)
    private DeliveryStatus status; // Використання enum для статусу доставки

    @Enumerated(EnumType.STRING) // Зберігає значення як рядок
    @Column(name = "delivery_type", nullable = false)
    private DeliveryType deliveryType;     // Використання enum для типу доставки


}