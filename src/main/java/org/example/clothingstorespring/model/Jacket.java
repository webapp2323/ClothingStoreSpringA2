package org.example.clothingstorespring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jacket {

    @Id
    private Long id;

    private String name;
    private String brand;
    private String size;
   private Long price;
   private String material;
   private boolean hasHood;


}
