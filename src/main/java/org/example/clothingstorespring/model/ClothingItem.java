package org.example.clothingstorespring.model;


import jakarta.persistence.*;
import lombok.Data;


import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "clothing_items")
public class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Size size;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ClothingItemType type;

    // Конструктор
    public ClothingItem(Long id, String name, Size size, BigDecimal price, Brand brand, ClothingItemType type) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.brand = brand;
        this.type = type;
    }

    public ClothingItem() {

    }
}




