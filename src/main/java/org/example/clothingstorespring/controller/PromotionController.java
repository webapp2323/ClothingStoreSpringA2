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
    public PromotionDTO addPromotion(@RequestBody PromotionDTO promotionDTO) { // Додано параметр
        try {
            if (promotionDTO.getStartDate().isAfter(promotionDTO.getEndDate())) {
                throw new IllegalArgumentException("Дата закінчення не може бути раніше дати початку.");
            }

            if (promotionDTO.getDiscount() < 0 || promotionDTO.getDiscount() > 100) {
                throw new IllegalArgumentException("Знижка повинна бути в межах від 0 до 100.");
            }

            Promotion promotion = new Promotion();
            promotion.setName(promotionDTO.getName());
            promotion.setDescription(promotionDTO.getDescription());
            promotion.setType(promotionDTO.getType());
            promotion.setDiscount(promotionDTO.getDiscount());
            promotion.setStartDate(promotionDTO.getStartDate().atStartOfDay());
            promotion.setEndDate(promotionDTO.getEndDate().atStartOfDay());
            promotion.setClothingItems(convertToEntity(promotionDTO.getClothingItems()));

            promotionService.addPromotion(promotion);
            log.info("Added new promotion: " + promotion);

            return convertToDTO(promotion);

        } catch (IllegalArgumentException e) {
            log.error("Validation error: " + e.getMessage());
            throw e; // Пробросити виключення далі
        } catch (Exception e) {
            log.error("An unexpected error occurred: " + e.getMessage());
            throw new RuntimeException("An unexpected error occurred while adding the promotion.");
        }
    }


    private PromotionDTO convertToDTO(Promotion promotion) {
        PromotionDTO dto = new PromotionDTO();
        dto.setId(promotion.getId());
        dto.setName(promotion.getName());
        dto.setDescription(promotion.getDescription());
        dto.setType(promotion.getType());
        dto.setDiscount(promotion.getDiscount());
        dto.setStartDate(promotion.getStartDate().toLocalDate());
        dto.setEndDate(promotion.getEndDate().toLocalDate());
        dto.setClothingItems(convertToDTO(promotion.getClothingItems()));
        return dto;
    }

    private Set<ClothingItemDTO> convertToDTO(Set<ClothingItem> clothingItems) {
        return clothingItems.stream()
                .map(item -> {
                    ClothingItemDTO dto = new ClothingItemDTO();
                    dto.setId(item.getId());
                    dto.setName(item.getName());

                    return dto;
                })
                .collect(Collectors.toSet());
    }


    private Set<ClothingItem> convertToEntity(Set<ClothingItemDTO> clothingItemsDTO) {
        return clothingItemsDTO.stream()
                .map(dto -> {
                    ClothingItem item = new ClothingItem();
                    item.setId(dto.getId());
                    item.setName(dto.getName());

                    return item;
                })
                .collect(Collectors.toSet());
    }

    @DeleteMapping("/delete/{id}")
    public void deletePromotion(@PathVariable Long id) {
        Promotion existingPromotion = promotionService.getPromotionById(id);
        if (existingPromotion == null) {
            log.info("Promotion not found for ID: " + id);
            throw new EntityNotFoundException("Promotion not found for ID: " + id);
        }

        log.info("Deleting promotion: " + existingPromotion);
        promotionService.deletePromotion(id);
        log.info("Deleted promotion with ID: " + id);
    }

//
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
//
//
//
    @GetMapping("/all")
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }
//
    @GetMapping("/id/{id}")
    public Promotion getPromotionById(@PathVariable Long id) {
        log.info("Identifying promotion using ID: " + id);
        Promotion promotion = promotionService.getPromotionById(id);
        log.info("Retrieved promotion: " + promotion);
        return promotion;
    }
}