package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
@Table(name = "shirt")
public class Shirt extends ClothingItem {

    @Enumerated(EnumType.STRING)
    private SleeveType sleeveType;

    @Enumerated(EnumType.STRING)
    private Size size;

    @Enumerated(EnumType.STRING)
    private Material material;

    @Override
    public String toString() {
        return super.toString() +
                " sleeve_Type=" + sleeveType +
                ", size=" + size +
                ", material='" + material + '\'' +
                '}';
    }
}
