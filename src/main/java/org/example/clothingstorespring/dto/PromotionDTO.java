package org.example.clothingstorespring.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.clothingstorespring.model.ClothingItem;
import org.example.clothingstorespring.model.PromotionType;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author owl
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromotionDTO {
    Long id;
    String name;
    String description;
    PromotionType type;
    double discount;
    LocalDate startDate;
    LocalDate endDate;
    Set<ClothingItem> clothingItems;
}


