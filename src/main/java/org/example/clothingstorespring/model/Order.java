package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Ідентифікатор замовлення

    private String customerName;
    private BigDecimal total;
    private LocalDateTime orderDate;
    private String status;

    @ManyToOne // Вказуємо, що багато замовлень можуть належати одному магазину
    @JoinColumn(name = "store_id") // Назва колонки у таблиці замовлень
    private Store store; // Поле для зв'язку з Store

    @ManyToOne // Вказуємо, що багато замовлень можуть належати одному користувачу
    @JoinColumn(name = "user_id") // Назва колонки в таблиці Orders
    private User user; // Поле для зв'язку з User

    // Геттери та сеттери
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user; // Геттер для поля user
    }

    public void setUser(User user) {
        this.user = user; // Сеттер для поля user
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}