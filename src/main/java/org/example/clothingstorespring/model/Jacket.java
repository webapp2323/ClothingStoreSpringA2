package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Jacket extends ClothingItem {

    @Enumerated(EnumType.STRING)
    private Size size; // Заміна на Enum для розміру

    @Enumerated(EnumType.STRING)
    private Material material; // Заміна на Enum для матеріалу

    private boolean hasHood;
}