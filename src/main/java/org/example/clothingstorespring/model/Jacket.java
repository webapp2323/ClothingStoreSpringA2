package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.lang.model.element.Name;

@Getter
@Setter
@Entity
public class Jacket extends ClothingItem {



    @Enumerated(EnumType.STRING)
    private Size size;

    @Enumerated(EnumType.STRING)
    private Material material;

    @Enumerated(EnumType.STRING)
    private Color color;

    private boolean has_Hood;
}