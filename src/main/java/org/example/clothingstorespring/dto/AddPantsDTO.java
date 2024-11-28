package org.example.clothingstorespring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.Color;
import org.example.clothingstorespring.model.Material;
import org.example.clothingstorespring.model.Size;
import org.example.clothingstorespring.model.SleeveType;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPantsDTO {

    private String name;
    private String brand;
    private BigDecimal price;
    private Size size;
    private Material material;
    private String color;
}

