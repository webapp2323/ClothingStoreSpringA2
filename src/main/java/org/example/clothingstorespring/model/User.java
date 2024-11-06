package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Ідентифікатор користувача

    private String username; // Ім'я користувача
    private String email; // Поле для електронної пошти
    private String password; // Поле для пароля

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders; // Колекція замовлень

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>(); // Колекція ролей

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password; // Геттер для пароля
    }

    public void setPassword(String password) { // Сеттер для пароля
        this.password = password;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public String getEmail() {
        return email; // Геттер для email
    }

    public void setEmail(String email) { // Сеттер для email
        this.email = email;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public Set<Role> getRoles() {
        return roles; // Геттер для ролей
    }

    public void setRoles(Set<Role> roles) { // Сеттер для ролей
        this.roles = roles;
    }
}