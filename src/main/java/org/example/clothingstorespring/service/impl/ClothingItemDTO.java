package org.example.clothingstorespring.service.impl;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

/**
 * @author owl
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClothingItemDTO {
    private Long id;
    private String name;
    private String size;
    private BigDecimal price;
    private String brand;
    private String type;
}

