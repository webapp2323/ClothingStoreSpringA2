package org.example.clothingstorespring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.*;

import javax.lang.model.element.Name;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddJacketDTO {



    @JsonProperty("size")
    private Size size;

    @JsonProperty("material")
    private Material material;

    @JsonProperty("color")
    private Color color;

    @JsonProperty("has_Hood")
    private boolean hasHood;

}