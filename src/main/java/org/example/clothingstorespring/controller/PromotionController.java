package org.example.clothingstorespring.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.clothingstorespring.dto.PromotionDTO;

import org.example.clothingstorespring.model.*;
import org.example.clothingstorespring.service.PromotionService;
import org.example.clothingstorespring.service.impl.ClothingItemDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService promotionService;

    @PostMapping("/add")
    public Promotion addPromotion(@RequestBody PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();
        // Заполнение полей из promotionDTO
        promotion.setName(promotionDTO.getName());
        promotion.setDescription(promotionDTO.getDescription());
        promotion.setType(promotionDTO.getType());
        promotion.setDiscount(promotionDTO.getDiscount());
        promotion.setStartDate(promotionDTO.getStartDate().atStartOfDay());
        promotion.setEndDate(promotionDTO.getEndDate().atStartOfDay());
        promotion.setClothingItems(convertToEntity(promotionDTO.getClothingItems())); // Преобразование clothing items
        
        promotionService.addPromotion(promotion);
        log.info("Added new promotion: " + promotion);
        return promotion;
    }

    @DeleteMapping("/delete/{id}")
    public void deletePromotion(@PathVariable Long id) {
        Promotion existingPromotion = promotionService.getPromotionById(id); // Получаем акцию по ID
        if (existingPromotion == null) { // Проверяем, существует ли акция
            log.info("Promotion not found for ID: " + id);
            throw new EntityNotFoundException("Promotion not found for ID: " + id);
        }
        // Логируем содержание удаляемой записи
        log.info("Deleting promotion: " + existingPromotion);
        promotionService.deletePromotion(id); // Удаляем акцию
        log.info("Deleted promotion with ID: " + id);
    }

    @PutMapping("/update/{id}")
    public Promotion updatePromotion(@PathVariable Long id, @RequestBody PromotionDTO promotionDTO) {
        Promotion existingPromotion = promotionService.getPromotionById(id);

        log.info("Existing promotion before update: " + existingPromotion);

        existingPromotion.setName(promotionDTO.getName());
        existingPromotion.setDescription(promotionDTO.getDescription());
        existingPromotion.setType(promotionDTO.getType());
        existingPromotion.setDiscount(promotionDTO.getDiscount());
        existingPromotion.setStartDate(promotionDTO.getStartDate().atStartOfDay());
        existingPromotion.setEndDate(promotionDTO.getEndDate().atStartOfDay());
        existingPromotion.setClothingItems(convertToEntity(promotionDTO.getClothingItems()));

        Promotion updatedPromotion = promotionService.updatePromotion(id, existingPromotion);

        log.info("Updated promotion: " + updatedPromotion);

        return updatedPromotion;
    }

    private Set<ClothingItem> convertToEntity(Set<ClothingItemDTO> clothingItemDTOs) {
        return clothingItemDTOs.stream()
                .map(dto -> new ClothingItem(
                        dto.getId(),
                        dto.getName(),
                        Size.valueOf(dto.getSize().toUpperCase()), 
                        dto.getPrice(),
                        Brand.valueOf(dto.getBrand().toUpperCase()), 
                        ClothingItemType.valueOf(dto.getType().toUpperCase()) // Удален лишний символ
                ))
                .collect(Collectors.toSet());
    }

    @GetMapping("/all")
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    @GetMapping("/id/{id}")
    public Promotion getPromotionById(@PathVariable Long id) {
        log.info("Identifying promotion using ID: " + id);
        Promotion promotion = promotionService.getPromotionById(id);
        log.info("Retrieved promotion: " + promotion);
        return promotion;
    }
}