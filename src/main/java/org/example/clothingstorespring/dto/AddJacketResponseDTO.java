package org.example.clothingstorespring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.DeliveryStatus;
import org.example.clothingstorespring.model.DeliveryType;
import org.example.clothingstorespring.model.Material;
import org.example.clothingstorespring.model.Size;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddJacketResponseDTO {

    private Long id;

    private Size size;

    private Material material;
    private Material color;
    private boolean hasHood;
    private String message;

}


