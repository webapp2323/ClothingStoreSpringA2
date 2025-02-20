package org.example.clothingstorespring.dto;

import org.example.clothingstorespring.model.ClothingItem;
import org.example.clothingstorespring.model.PromotionType;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author owl
 */
public class PromotionResponsDTO {
    Long id;
    String name;
    String description;
    PromotionType type;
    double discount;
    LocalDate startDate;
    LocalDate endDate;
    Set<ClothingItem> clothingItems;
}
