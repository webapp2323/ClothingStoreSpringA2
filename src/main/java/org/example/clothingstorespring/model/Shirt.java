package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "shirt")
public class Shirt extends ClothingItem {

    @Enumerated(EnumType.STRING)
    private SleeveType sleeve_type;

    @Enumerated(EnumType.STRING)
    private Size size;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.STRING)
    private Material material;

    @Override
    public String toString() {
        return "Shirt{" +
                "sleeveType=" + sleeve_type +
                ", size=" + size +
                ", color=" + color +
                ", material=" + material +
                '}';
    }
}

