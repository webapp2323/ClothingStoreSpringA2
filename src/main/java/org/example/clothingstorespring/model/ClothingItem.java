package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@Data
@MappedSuperclass
//@MappedSuperclass: Анотація вказує, що клас ClothingItem не буде мати власної таблиці в базі даних, але його поля будуть успадковані інші класами.
public abstract class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Генерація ID
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;

    @Override
    public String toString() {
        return "{" +
                "id=" + id + // Добавьте идентификатор
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
/*
2024-10-10 07:23:30 - Received request to add shirt: {name='Lightweight Shirt', brand='Brand F', price=24.99, sleeve_Type=LONG, size=S, material='LINEN'}
2024-10-10 07:23:30 - Shirt successfully added: {name='Lightweight Shirt', brand='Brand F', price=24.99, sleeve_Type=LONG, size=S, material='LINEN'}
2024-10-10 07:23:30 - 200 OK: Request successful. The server has responded as required.
 */
