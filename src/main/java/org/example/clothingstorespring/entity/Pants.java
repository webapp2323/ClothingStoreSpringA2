package org.example.clothingstorespring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pants {

    @Id
    private Long id;

    private String brand;
    private String size;
    private Long price;
    private String material;
    private PantsType type;
    private String name;
}
