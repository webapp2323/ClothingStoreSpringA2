package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "shirt")
public class Shirt extends ClothingItem {

    @Enumerated(EnumType.STRING)
    private Sleeve_Type sleeve_Type;

    @Enumerated(EnumType.STRING) 
    private Size size;

    private String material;
}