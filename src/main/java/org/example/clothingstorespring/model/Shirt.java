package org.example.clothingstorespring.model;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "Shirt")
public class Shirt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматично генерує ID
    private Long id;


    private String name;
    private String brand;

    @Column(name = "price_$", unique = true)
    private double price;

    @Enumerated(EnumType.STRING)
    private SleeveType sleeveType;

    @Enumerated(EnumType.STRING)
    private PantsSize size;


}
