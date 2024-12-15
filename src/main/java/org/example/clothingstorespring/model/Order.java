package org.example.clothingstorespring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
    @Entity
@Table(name = "\"orders\"")
    public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    @Column(name = "total_amount")
    private BigDecimal total;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @JsonBackReference
    private Store store;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Payment payment;

    @OneToOne(mappedBy = "order", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItem> orderItems = new ArrayList<>();

    // Метод для установки элементов заказа
    public void setItems(List<OrderItem> orderItems) {
        this.orderItems.clear();
        if (orderItems != null) {
            for (OrderItem item : orderItems) {
                item.setOrder(this);
            }
            this.orderItems.addAll(orderItems);
        }
    }

    // Метод для установки платежа
    public void setPayment(Payment payment) {
        if (payment != null) {
            payment.setOrder(this);
        }
        this.payment = payment;
    }

    // Метод для установки доставки
    public void setDelivery(Delivery delivery) {
        if (delivery != null) {
            delivery.setOrder(this);
        }
        this.delivery = delivery;
    }
}