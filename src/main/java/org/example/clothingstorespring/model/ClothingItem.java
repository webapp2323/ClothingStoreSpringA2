package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@MappedSuperclass
//@MappedSuperclass: Анотація вказує, що клас ClothingItem не буде мати власної таблиці в базі даних, але його поля будуть успадковані інші класами.
public abstract class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Генерація ID
    private Long id;
    @NotNull
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

