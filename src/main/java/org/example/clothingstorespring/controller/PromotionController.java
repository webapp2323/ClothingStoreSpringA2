package org.example.clothingstorespring.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.clothingstorespring.dto.PromotionDTO;
import org.example.clothingstorespring.model.Promotion;
import org.example.clothingstorespring.repository.PromotionRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author owl
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionRepository promotionRepository;

    @PostMapping("/add")
    public void addPromotion(@RequestBody PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();
//        promotion.setName(promotionDTO.getName());
//        promotion.setDescription(promotionDTO.getDescription());
//        promotion.setType(promotionDTO.getType());
//        promotion.setDiscount(promotionDTO.getDiscount());
//        promotion.setStartDate(promotionDTO.getStartDate());
//        promotion.setEndDate(promotionDTO.getEndDate());
//        promotion.setClothingItems(promotionDTO.getClothingItems());
        log.info("Added new promotion: " + promotionRepository.save(
                Promotion.builder()
                        .name(promotion.getName())
                        .description(promotion.getDescription())
                        .type(promotion.getType())
                        .discount(promotion.getDiscount())
                        .startDate(promotion.getStartDate())
                        .endDate(promotion.getEndDate())
                        .clothingItems(promotion.getClothingItems())
                        .build())
        );

    }

    //    @DeleteMapping("/delete/{id}")
//    public void deletePromotion(@PathVariable Long id) {
//        promotionService.deletePromotion(id);
//        log.info("Deleted promotion with ID: " + id);
//    }
//
//    @PutMapping("/update/{id}")
//    public Promotion updatePromotion(@PathVariable Long id, @RequestBody PromotionDTO promotionDTO) {
//        Promotion promotion = new Promotion();
//        promotion.setName(promotionDTO.getName());
//        promotion.setDescription(promotionDTO.getDescription());
//        promotion.setType(promotionDTO.getType());
//        promotion.setDiscount(promotionDTO.getDiscount());
//        promotion.setStartDate(promotionDTO.getStartDate());
//        promotion.setEndDate(promotionDTO.getEndDate());
//        promotion.setClothingItems(promotionDTO.getClothingItems());
//        Promotion updatedPromotion = promotionService.updatePromotion(id, promotion);
//        log.info("Updated promotion: " + updatedPromotion);
//        return updatedPromotion;
//    }
//
//    @GetMapping("/all")
//    public List<Promotion> getAllPromotions() {
//        return promotionService.getAllPromotions();
//    }
//
    @GetMapping("/id/{id}")
    public Promotion getPromotionById(@PathVariable int id) {
        log.info("Identifying promotion using ID: " + id);

        try {
            Promotion promotion = promotionRepository.findById((long) id)
                    .orElseThrow(() -> new EntityNotFoundException("Promotion not found for ID: " + id));
            log.info("Retrieved promotion: " + promotion);
            return promotion;
        } catch (EntityNotFoundException e) {
            log.error("Error: " + e.getMessage());
            throw e;
        }
    }
}
