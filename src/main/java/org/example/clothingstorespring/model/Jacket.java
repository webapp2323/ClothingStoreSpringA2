package org.example.clothingstorespring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.lang.model.element.Name;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Jacket extends ClothingItem {



    @NotNull
    private String brand;
    private String size;
    private String color;
    private BigDecimal price;
    private String material;
    private boolean hasHood;
}