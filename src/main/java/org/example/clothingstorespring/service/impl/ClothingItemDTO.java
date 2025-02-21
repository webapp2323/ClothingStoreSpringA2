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
    private String size; // Это строка, которую нужно будет преобразовать
    private BigDecimal price;
    private String brand; // Это строка, которую нужно будет преобразовать
    private String type; // Это строка, которую нужно будет преобразовать
}

