package org.example.clothingstorespring.model;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
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
    private Store store;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Payment payment;

    @OneToOne(mappedBy = "order", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    // Метод для установки элементов заказа
    public void setItems(List<OrderItem> orderItems) {
        this.orderItems.clear(); // Очистить текущий список, если требуется
        if (orderItems != null) {
            for (OrderItem item : orderItems) {
                item.setOrder(this); // Устанавливаем текущий объект Order в OrderItem
            }
            this.orderItems.addAll(orderItems); // Добавляем новые элементы
        }
    }


    // Метод для установки платежа
    public void setPayment(Payment payment) {
        if (payment != null) {
            payment.setOrder(this); // Установить текущий объект Order в Payment
        }
        this.payment = payment; // Установить платеж
    }

    // Метод для установки доставки
    public void setDelivery(Delivery delivery) {
        if (delivery != null) {
            delivery.setOrder(this); // Установить текущий объект Order в Delivery
        }
        this.delivery = delivery; // Установить доставку
    }

    // Метод для установки имени клиента
    public void setCustomerName(String customerName) {
        this.customerName = customerName; // Устанавливаем имя клиента
    }

    // Метод для получения имени клиента
    public String getCustomerName() {
        return customerName; // Возвращаем имя клиента
    }

    // Метод для установки общей суммы заказа
    public void setTotal(BigDecimal total) {
        this.total = total; // Устанавливаем общую сумму
    }

    public void setOrderDate(LocalDateTime now) {
        this.orderDate = now;
    }

    public void setStatus(OrderStatus orderStatus) {
        this.status = orderStatus;
    }

    public OrderStatus getStatus() {
        return status;
}

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }
}
