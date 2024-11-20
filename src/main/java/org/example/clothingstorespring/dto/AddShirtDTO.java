package org.example.clothingstorespring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.Color;
import org.example.clothingstorespring.model.Material;
import org.example.clothingstorespring.model.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddShirtDTO {



    @JsonProperty("size")
    private Size size;

    @JsonProperty("material")
    private Material material;

    @JsonProperty("color")
    private Color color;

    @JsonProperty("has_Hood")
    private boolean hasHood;

}