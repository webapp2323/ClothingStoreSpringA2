package org.example.clothingstorespring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.Material;
import org.example.clothingstorespring.model.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddShirtResponseDTO {

    private Long id;

    private Size size;

    private Material material;
    private Material color;
    private boolean hasHood;
    private String message;

}


