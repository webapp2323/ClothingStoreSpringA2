package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@MappedSuperclass
//@MappedSuperclass: Анотація вказує, що клас ClothingItem не буде мати власної таблиці в базі даних, але його поля будуть успадковані інші класами.
public abstract class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Генерація ID
    private Long id;

    private String name;
    private String brand;

    @Column(name = "price_$", unique = true)
    private BigDecimal price;

}