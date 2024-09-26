package org.example.clothingstorespring.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Shirt {

    @Id
    private Long id;

    private String name;
    private String brand;
    private SleeveType sleeveType;
    private Long price;
    private double size;


}
