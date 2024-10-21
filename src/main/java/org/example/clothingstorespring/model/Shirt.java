package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
@Table(name = "shirt")
public class Shirt extends ClothingItem {

    @Enumerated(EnumType.STRING)
    private Sleeve_Type sleeve_Type;

    @Enumerated(EnumType.STRING)
    private Size size;

    private String material;

    @Override
    public String toString() {
        return super.toString() +
                " sleeve_Type=" + sleeve_Type +
                ", size=" + size +
                ", material='" + material + '\'' +
                '}';
    }
}
/*
2024-10-10 07:24:41 - Received request to add shirt: {name='Lightweight Shirt', brand='Brand F', price=24.99, sleeve_Type=LONG, size=S, material='LINEN'}
2024-10-10 07:24:41 - Shirt successfully added: {name='Lightweight Shirt', brand='Brand F', price=24.99, sleeve_Type=LONG, size=S, material='LINEN'}
2024-10-10 07:24:41 - 200 OK: Request successful. The server has responded as required.

 */