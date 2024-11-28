package org.example.clothingstorespring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.Color;
import org.example.clothingstorespring.model.Material;
import org.example.clothingstorespring.model.Size;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddPantsResponseDTO {

    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private Size size;
    private Color color;
    private Material material;
    private String message;

}


