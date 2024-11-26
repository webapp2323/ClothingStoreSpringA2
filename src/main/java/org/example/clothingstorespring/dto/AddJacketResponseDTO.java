package org.example.clothingstorespring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddJacketResponseDTO {

    private Long id;
    private String name;
    private String brand;
    private String color;
    private String size;
    private BigDecimal price;
    private String material;
    private boolean hasHood;
    private String message;

}


