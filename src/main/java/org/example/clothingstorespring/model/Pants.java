package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pants extends ClothingItem {

    @Enumerated(EnumType.STRING)
    private Size size;

    @Enumerated(EnumType.STRING)
    private Material material;
}