package org.example.clothingstorespring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.Color;
import org.example.clothingstorespring.model.Material;
import org.example.clothingstorespring.model.Size;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPantsDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("size")
    private Size size;

    @JsonProperty("material")
    private Material material;
}

