package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity // Підклас, без @Table
@DiscriminatorValue("SHIRT")
public class Shirt extends ClothingItem {

    @Enumerated(EnumType.STRING)
    private SleeveType sleeve_type;

    @Enumerated(EnumType.STRING)
    private Size size;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.STRING)
    private Material material;

    @Enumerated(EnumType.STRING)
    private Brand brand;


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

