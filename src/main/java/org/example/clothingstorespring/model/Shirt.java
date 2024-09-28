package org.example.clothingstorespring.model;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
public class Shirt {

    @Id
    private Long id;

    private String name;
    private String brand;
    private SleeveType sleeveType;
    private double price;
    private String size;


}
